package de.stiffi.DPHelpers;

import junit.framework.Assert;

import org.junit.Test;


public class DateTest {


	@Test
	public void testIsValidDate() {
		Assert.assertFalse( Date.isValidDate( 2000, 13, 10 ) );
		Assert.assertTrue( Date.isValidDate( 2012, 12, 31 ) );
	}

}
