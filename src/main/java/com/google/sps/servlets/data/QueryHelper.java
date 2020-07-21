package com.google.sps.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import java.util.List;

public final class QueryHelper {

  /**
   * Returns a list of entities that have been filtered based on their longitude in relation to the
   * selected office's longitude
   *
   * @param entityType: The type of entity to be queried
   * @param entityLimit: The max number of entityType to return
   * @param selectedOffice: The office for which to find nearby entities
   * @param kilometers: Distance in kilometers to create a range with from the office's center
   * @return List of filtered entities
   */
  public static List<Entity> getDistanceBasedEntities(
      EntityType entityType, int entityLimit, Office selectedOffice, double kilometers) {

    CompositeFilter distanceFromOfficeFilter =
        CoordinateCalculator.createLongitudeBoundFilter(
            kilometers, selectedOffice.getLatitude(), selectedOffice.getLongitude());

    // Retrieving Listings from DataStore
    Query query = new Query(entityType.getValue()).setFilter(distanceFromOfficeFilter);
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);

    return results.asList(FetchOptions.Builder.withLimit(entityLimit));
  }
}