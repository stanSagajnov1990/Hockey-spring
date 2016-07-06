package com.stanislav.spring.services;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.stanislav.spring.model.Game;

public class ServiceUtils {

	public static Pageable pageableForAllEntities(final String... sorts){
		return new Pageable() {
			
			public Sort getSort() {
				Sort sort = null;
				for (String sortEntry : sorts) {
					Sort newSort = null;
					String[] parts = sortEntry.split("\\W", 2);
					if (parts.length > 1) {
						newSort = new Sort(Direction.fromString(parts[1].trim()), parts[0].trim());
					}
					else if (parts.length > 0) {
						newSort = new Sort(Direction.ASC, parts[0].trim());
					}

					if (newSort != null) {
						if (sort == null)
							sort = newSort;
						else
							sort = sort.and(newSort);
					}
				}
				return sort;
			}
			
			public int getPageSize() {
				return Integer.MAX_VALUE;
			}
			
			public int getPageNumber() {
				return 0;
			}
			
			public int getOffset() {
				return 0;
			}
			
		};
	}

	public static Pageable pageableFor(final int first, final int pageSize, final String sortField, final String sortOrder) {
		
		return new Pageable() {
			
			public Sort getSort() {
				if(StringUtils.isBlank(sortField) || "UNSORTED".equals(sortOrder))
				return null;
				else
					return new Sort(("DESCENDING".equals(sortOrder)) ? Direction.DESC : Direction.ASC, sortField);
			}
			
			public int getPageSize() {
				return pageSize;
			}
			
			public int getPageNumber() {
				return first / pageSize;
			}
			
			public int getOffset() {
				return 0;
			}
		};
	}

	public static <T> Specification<T> matches(final Map<String, String> conditions) {
		return new Specification<T>() {
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p = null;
				for (Entry<String, String> condition : conditions.entrySet()) {
					if (StringUtils.contains(condition.getValue(), '%')) {
						Path<String> field = root.get(condition.getKey());
						Predicate q = cb.like(cb.upper(field), (condition.getValue()).toUpperCase());
						if (p == null)
							p = q;
						else
							p = cb.and(p, q);
					}
					else {
						Path<?> field = root.get(condition.getKey());
						Predicate q = cb.equal(field, condition.getValue());
						if (p == null)
							p = q;
						else
							p = cb.and(p, q);
					}
				}
				return p;
			}
		};
	}
	
}
