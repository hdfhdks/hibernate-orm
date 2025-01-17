/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.resource.jdbc.spi;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;

/**
 * Provides the {@code JdbcSession} with contextual information it needs during its lifecycle.
 *
 * @author Steve Ebersole
 */
public interface JdbcSessionContext {
	boolean isScrollableResultSetsEnabled();
	boolean isGetGeneratedKeysEnabled();
	int getFetchSize();

	PhysicalConnectionHandlingMode getPhysicalConnectionHandlingMode();

	boolean doesConnectionProviderDisableAutoCommit();

	StatementInspector getStatementInspector();

	JdbcObserver getObserver();

	/**
	* Retrieve the session factory for this environment.
	*
	* @return The session factory
	*/
	SessionFactoryImplementor getSessionFactory();

	ServiceRegistry getServiceRegistry();
}
