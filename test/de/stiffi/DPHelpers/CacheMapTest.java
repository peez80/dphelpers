package de.stiffi.DPHelpers;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CacheMapTest {

	private static CacheMap<String, String> cacheMap = null;

	@Before
	public void setUp() throws Exception {
		// Eine CacheMap bauen mit ein paar Elementen
		System.out.println( "Creating CacheMap with 2 sec. timeout." );
		cacheMap = new CacheMap<String, String>();
		cacheMap.setDefaultCacheTime( 2000 ); // 2 Sekunden timeout

		cacheMap.put( "key", "value" );

	}

	@Test
	public void testSize() {
		Assert.assertTrue( cacheMap.size() == 1 );
		try {
			Thread.sleep( 2100 );
		} catch (InterruptedException e) {
		}
		Assert.assertTrue( cacheMap.size() == 0 );
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse( "CacheMap sollte noch nicht leer sein.", cacheMap.isEmpty() );
		try {
			Thread.sleep( 2100 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue( "CacheMap sollte jetzt eigentlich leer sein.", cacheMap.isEmpty() );
	}

	@Test
	public void testContainsKey() {
		Assert.assertTrue( cacheMap.containsKey( "key" ) );
		Assert.assertFalse( cacheMap.containsKey( "keysolltenichtdasein" ) );
	}

	@Test
	public void testIsInCache() {
		Assert.assertTrue( cacheMap.isInCache( "key" ) );
		try {
			Thread.sleep( 2100 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertFalse( cacheMap.isInCache( "key" ) );
	}

	@Test
	public void testGet() {
		Object v= cacheMap.get("key");
		Assert.assertTrue((v instanceof String) && v.equals("value"));		
	}

}
