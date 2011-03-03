package org.anddev.andengine.extension.multiplayer.protocol.shared;

import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection.IConnectionListener;

/**
 * @author Nicolas Gramlich
 * @since 13:51:22 - 03.03.2011
 */
public abstract class Connector<T extends Connection> implements IConnectionListener {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected final T mConnection;
	protected IConnectorListener<? extends Connector<T>> mConnectorListener;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Connector(final T pConnection) {
		this.mConnection = pConnection;
		this.mConnection.setConnectionListener(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public T getConnection() {
		return this.mConnection;
	}

	public boolean hasConnectorListener() {
		return this.mConnectorListener != null;
	}

	public IConnectorListener<? extends Connector<T>> getConnectorListener() {
		return this.mConnectorListener;
	}

	protected void setConnectorListener(final IConnectorListener<? extends Connector<T>> pConnectorListener) {
		this.mConnectorListener = pConnectorListener;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	public static interface IConnectorListener<T extends Connector<?>> {
		// ===========================================================
		// Final Fields
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================

		public void onConnected(final T pConnector);
		public void onDisconnected(final T pConnector);
	}
}
