package org.exoplatform.social.client.core.service.util;

import java.util.List;

import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestComment;

public class ServiceUtils {

  
  /**
   * Fill RestActivities comment with itself
   * @param restActivities
   */
  public static void fillRestActivities(final List<RestActivity> restActivities){
    if(restActivities != null && restActivities.size() > 0){
      for(RestActivity restActivity : restActivities){
        fillRestActivity(restActivity);
      }
    }
  }  

  /**
   * Fill RestActivity's comment with itself
   * @param restActivity
   */
  public static void fillRestActivity(final RestActivity restActivity){
    if(restActivity != null){
      List<RestComment> restComments = restActivity.getAvailableComments();
      fillRestComments(restActivity, restComments);
    }
  }
  
  /**
   * Fill RestActivities comment with itself
   * @param restActivities
   */
  public static void fillRestComments(final RestActivity restActivity, final List<RestComment> restComments){
    if(restComments != null && restComments.size() > 0){
      for(RestComment restComment : restComments){
        fillRestComment(restActivity, restComment);
      }
    }
  }

  /**
   * Fill RestComment with itself
   * @param restActivities
   */  
  public static void fillRestComment(final RestActivity restActivity, final RestComment restComment){
    if(restComment != null){
      restComment.setActivity(restActivity);
    }
  }
  
}
