package de.stiffi.DPHelpers.businessobject.interfaces;

import java.util.Date;

public interface TimestampMarkableSoftDelete extends SoftDeleteable {

	public void setDeletedTimestamp( Date d );

	public Date getDeletedTimestamp();
}
