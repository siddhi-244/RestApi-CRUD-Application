package com.practice;

//import com.github.arteam.jdbi3.JdbiFactory;
import com.practice.core.entity.ReviewEntity;
import com.practice.dao.BookReviewEntityDao;
import com.practice.dao.ReviewEntityDao;
import com.practice.resources.BookReviewResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import org.skife.jdbi.v2.DBI;
import io.dropwizard.jdbi.DBIFactory;


public class DropwizardJdbiApplication extends Application<DropwizardJdbiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardJdbiApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardJdbi";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardJdbiConfiguration> bootstrap) {
        // TODO: application initialization
    }


    @Override
    public void run(final DropwizardJdbiConfiguration configuration,
                    final Environment environment){
        // TODO: implement application
//        final DBIFactory factory = new DBIFactory();
//        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
//
//        final BookReviewEntityDao personDAO = jdbi.onDemand(BookReviewEntityDao.class);
//        final BookReviewResource personResource = new BookReviewResource(personDAO);
//
//        environment.jersey().register(personResource);

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment,configuration.getDataSourceFactory(), "postgresql");
        final BookReviewEntityDao bookDao = jdbi.onDemand(BookReviewEntityDao.class);
        final ReviewEntityDao reviewDao=jdbi.onDemand(ReviewEntityDao.class);
        environment.jersey().register(new BookReviewResource(bookDao,reviewDao));

    }


}
