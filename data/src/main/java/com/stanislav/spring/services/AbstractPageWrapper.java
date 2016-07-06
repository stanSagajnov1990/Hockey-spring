package com.stanislav.spring.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class AbstractPageWrapper<T> implements Page<T> {

	private Page<T> page = null;

	protected AbstractPageWrapper(Page<T> page, Pageable pageable) {
		if (pageable == null)
			pageable = ServiceUtils.pageableForAllEntities();
		List<T> processed = new ArrayList<T>();
		for (T entity : page.getContent()) {
			processed.add(processEntity(entity));
		}
		this.page = new PageImpl<T>(processed, pageable, page.getTotalElements());
	}
	
	protected abstract T processEntity(T entity);

	
	public int getNumber() {
		return page.getNumber();
	}

	public int getSize() {
		return page.getSize();
	}

	public int getTotalPages() {
		return page.getTotalPages();
	}

	public int getNumberOfElements() {
		return page.getNumberOfElements();
	}

	public long getTotalElements() {
		return page.getTotalElements();
	}

	public boolean hasPreviousPage() {
		return page.hasPreviousPage();
	}

	public boolean isFirstPage() {
		return page.isFirstPage();
	}

	public boolean hasNextPage() {
		return page.hasNextPage();
	}

	public boolean isLastPage() {
		return page.isLastPage();
	}

	public Iterator<T> iterator() {
		return page.iterator();
	}

	public List<T> getContent() {
		return page.getContent();
	}

	public boolean hasContent() {
		return page.hasContent();
	}

	public Sort getSort() {
		return page.getSort();
	}

}
