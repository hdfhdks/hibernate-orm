/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */

/**
 * This package defines the boot-time metamodel, which is an interpretation
 * of the domain model (entity classes, embeddable classes, and attributes)
 * and the mapping of these "domain model parts" to the database. It is
 * {@linkplain org.hibernate.boot.model.process built incrementally} from
 * {@linkplain org.hibernate.annotations annotations} and XML-based mappings.
 *
 * @implNote Ultimately, as part of the process of creating the
 *           {@link org.hibernate.SessionFactory}, Hibernate
 *           transforms this boot-time metamodel to its runtime
 *           {@linkplain org.hibernate.metamodel.mapping mapping metamodel}.
 */
package org.hibernate.boot.model;
