package org.zalando.catwatch.backend.repo;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.query.DateTimeSubQuery;
import org.zalando.catwatch.backend.model.Project;
import org.zalando.catwatch.backend.model.QProject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

class ProjectRepositoryImpl implements ProjectRepositoryCustom {


    @Override
    public List<Project> findProjects(String organization, Optional<String> query, Optional<String> language) {
        return null;
    }

    @Override
    public List<Project> findProjects(String organization, Date snapshotDate, Optional<String> query, Optional<String> language) {
        return null;
    }
}
