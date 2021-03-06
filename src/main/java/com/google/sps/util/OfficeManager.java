package com.google.sps.util;

import com.google.sps.object.Office;
import java.util.HashMap;

public final class OfficeManager {
  public static final HashMap<String, Office> offices =
      new HashMap<String, Office>() {
        {
          put("svl", new Office("Sunnyvale", 37.4030, -122.0326));
          put("mtv", new Office("Mountain View", 37.4220, -122.0841));
        }
      };
}
