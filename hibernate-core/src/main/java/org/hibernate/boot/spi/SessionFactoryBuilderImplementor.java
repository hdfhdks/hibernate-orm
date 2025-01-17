/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.boot.spi;

import org.hibernate.boot.SessionFactoryBuilder;

/**
 * Additional contract for {@link SessionFactoryBuilder} mainly intended for implementors
 * of {@link SessionFactoryBuilderFactory}.
 *
 * @author Steve Ebersole
 */
public interface SessionFactoryBuilderImplementor extends SessionFactoryBuilder {

	void disableJtaTransactionAccess();

	default void disableRefreshDetachedEntity() {
	}

	/**
	 * Build the SessionFactoryOptions that will ultimately be passed to SessionFactoryImpl constructor.
	 *
	 * @return The options.
	 */
	SessionFactoryOptions buildSessionFactoryOptions();
}
