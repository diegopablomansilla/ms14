package com.massoftware.b.service.util;

public class GenericFilter implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private Integer limit;

	private Integer offset;

	private Integer orderBy = 1;

	private Boolean orderByDesc = false;

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Limit
	public Integer getLimit() {
		this.limit = (this.limit != null && this.limit < 1) ? null : this.limit;
		return this.limit;
	}

	// SET Limit
	public void setLimit(Integer limit) {
		limit = (limit == null || limit < 1) ? 50 : limit;
		this.limit = limit;
	}

	// GET Offset
	public Integer getOffset() {
		offset = (offset == null || offset < 0) ? 0 : offset;
		return this.offset;
	}

	// SET Offset
	public void setOffset(Integer offset) {
		offset = (offset == null || offset < 0) ? 0 : offset;
		this.offset = offset;
	}

	// GET Order by att
	public Integer getOrderBy() {
		return this.orderBy;
	}

	// SET Order by att
	public void setOrderBy(Integer orderBy) {
		this.orderBy = (orderBy == null) ? 1 : orderBy;
	}

	// GET Order by desc
	public Boolean getOrderByDesc() {
		return this.orderByDesc;
	}

	// SET Order by desc
	public void setOrderByDesc(Boolean orderByDesc) {
		orderByDesc = (orderByDesc == null) ? false : orderByDesc;
		this.orderByDesc = orderByDesc;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj instanceof GenericFilter == false) {
			return false;
		}

		GenericFilter other = (GenericFilter) obj;

		// -------------------------------------------------------------------

		if (other.getLimit() == null && this.getLimit() != null) {
			return false;
		}

		if (other.getLimit() != null && this.getLimit() == null) {
			return false;
		}

		if (other.getLimit() != null && this.getLimit() != null) {

			if (other.getLimit().equals(this.getLimit()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getOffset() == null && this.getOffset() != null) {
			return false;
		}

		if (other.getOffset() != null && this.getOffset() == null) {
			return false;
		}

		if (other.getOffset() != null && this.getOffset() != null) {

			if (other.getOffset().equals(this.getOffset()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getOrderBy() == null && this.getOrderBy() != null) {
			return false;
		}

		if (other.getOrderBy() != null && this.getOrderBy() == null) {
			return false;
		}

		if (other.getOrderBy() != null && this.getOrderBy() != null) {

			if (other.getOrderBy().equals(this.getOrderBy()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getOrderByDesc() == null && this.getOrderByDesc() != null) {
			return false;
		}

		if (other.getOrderByDesc() != null && this.getOrderByDesc() == null) {
			return false;
		}

		if (other.getOrderByDesc() != null && this.getOrderByDesc() != null) {

			if (other.getOrderByDesc().equals(this.getOrderByDesc()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;
	}

	@Override
	public GenericFilter clone() {
		GenericFilter other = new GenericFilter();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());

		return other;
	}

}
