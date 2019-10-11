package com.massoftware.a.model.util;

import com.massoftware.c.persist.dao.sorm.Identifiable;

public class EntityId implements Identifiable, Cloneable, Comparable<EntityId> {

	// ---------------------------------------------------------------------------------------------------------------------------

	protected EntityId _originalDTO;

	protected String id;

	// ---------------------------------------------------------------------------------------------------------------------------

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		EntityId other = (EntityId) obj;

		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;

		return true;
	}

	@Override
	public int compareTo(EntityId entityId) {

		return this.getId().compareTo(entityId.getId());
	}

	@Override
	public String toString() {

		if (this.getId() != null) {
			return this.getId();
		}

		return "";
	}

} // END CLASS -----------------------------------------------------------------