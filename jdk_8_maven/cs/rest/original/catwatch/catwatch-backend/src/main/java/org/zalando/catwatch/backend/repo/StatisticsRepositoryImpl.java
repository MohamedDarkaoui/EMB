package org.zalando.catwatch.backend.repo;

import com.mysema.query.jpa.impl.JPAQuery;
import org.zalando.catwatch.backend.model.QStatistics;
import org.zalando.catwatch.backend.model.Statistics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class StatisticsRepositoryImpl implements StatisticsRepositoryCustom{

    @Override
    public Optional<Date> getLatestSnaphotDateBefore(String organization, Date date) {
        return Optional.empty();
    }

    @Override
    public Optional<Date> getEarliestSnaphotDate(String organization) {
        return Optional.empty();
    }
}
