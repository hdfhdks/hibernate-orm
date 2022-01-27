/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.ast.tree.from;

import java.util.function.Consumer;

import org.hibernate.query.spi.NavigablePath;
import org.hibernate.sql.ast.SqlAstJoinType;
import org.hibernate.sql.ast.spi.FromClauseAccess;
import org.hibernate.sql.ast.spi.SqlAliasBaseGenerator;
import org.hibernate.sql.ast.spi.SqlAstCreationContext;
import org.hibernate.sql.ast.spi.SqlAstCreationState;
import org.hibernate.sql.ast.spi.SqlExpressionResolver;
import org.hibernate.sql.ast.tree.predicate.Predicate;

/**
 * @author Steve Ebersole
 */
public interface TableGroupJoinProducer extends TableGroupProducer {

	SqlAstJoinType getDefaultSqlAstJoinType(TableGroup parentTableGroup);

	boolean isSimpleJoinPredicate(Predicate predicate);

	/**
	 * Create a TableGroupJoin as defined for this producer
	 *
	 * The sqlAstJoinType may be null to signal that the join is for an implicit path.
	 */
	default TableGroupJoin createTableGroupJoin(
			NavigablePath navigablePath,
			TableGroup lhs,
			String explicitSourceAlias,
			SqlAstJoinType sqlAstJoinType,
			boolean fetched,
			boolean addsPredicate,
			SqlAstCreationState creationState) {
		return createTableGroupJoin(
				navigablePath,
				lhs,
				explicitSourceAlias,
				sqlAstJoinType,
				fetched,
				addsPredicate,
				creationState.getSqlAliasBaseGenerator(),
				creationState.getSqlExpressionResolver(),
				creationState.getFromClauseAccess(),
				creationState.getCreationContext()
		);
	}

	/**
	 * Create a TableGroupJoin as defined for this producer
	 *
	 * The sqlAstJoinType may be null to signal that the join is for an implicit path.
	 */
	TableGroupJoin createTableGroupJoin(
			NavigablePath navigablePath,
			TableGroup lhs,
			String explicitSourceAlias,
			SqlAstJoinType sqlAstJoinType,
			boolean fetched,
			boolean addsPredicate,
			SqlAliasBaseGenerator aliasBaseGenerator,
			SqlExpressionResolver sqlExpressionResolver,
			FromClauseAccess fromClauseAccess,
			SqlAstCreationContext creationContext);

	/**
	 * Create a TableGroup as defined for this producer
	 *
	 * The sqlAstJoinType may be null to signal that the join is for an implicit path.
	 */
	default TableGroup createRootTableGroupJoin(
			NavigablePath navigablePath,
			TableGroup lhs,
			String explicitSourceAlias,
			SqlAstJoinType sqlAstJoinType,
			boolean fetched,
			Consumer<Predicate> predicateConsumer,
			SqlAstCreationState creationState) {
		return createRootTableGroupJoin(
				navigablePath,
				lhs,
				explicitSourceAlias,
				sqlAstJoinType,
				fetched,
				predicateConsumer,
				creationState.getSqlAliasBaseGenerator(),
				creationState.getSqlExpressionResolver(),
				creationState.getFromClauseAccess(),
				creationState.getCreationContext()
		);
	}

	/**
	 * Create a TableGroupJoin as defined for this producer
	 *
	 * The sqlAstJoinType may be null to signal that the join is for an implicit path.
	 */
	TableGroup createRootTableGroupJoin(
			NavigablePath navigablePath,
			TableGroup lhs,
			String explicitSourceAlias,
			SqlAstJoinType sqlAstJoinType,
			boolean fetched,
			Consumer<Predicate> predicateConsumer,
			SqlAliasBaseGenerator aliasBaseGenerator,
			SqlExpressionResolver sqlExpressionResolver,
			FromClauseAccess fromClauseAccess,
			SqlAstCreationContext creationContext);
}
