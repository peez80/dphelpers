package de.stiffi.DPHelpers;

/**
 * Default Handler Interface - can be used whenever a reaction so anything is necessary
 * <p/>
 * Created by peez on 26.12.2014.
 */
public interface Handler<T> {
	public void handle(T value);
}
