package com.signette.domains;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the POST database table.
 * 
 */
@Embeddable
public class PostPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TRIP_ID", insertable=false, updatable=false)
	private long tripId;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	public PostPK() {
	}
	public long getTripId() {
		return this.tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PostPK)) {
			return false;
		}
		PostPK castOther = (PostPK)other;
		return 
			(this.tripId == castOther.tripId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.tripId ^ (this.tripId >>> 32)));
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		
		return hash;
	}
}