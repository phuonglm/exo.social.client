/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.client.core.util;

import java.util.LinkedList;
import java.util.List;

import org.exoplatform.social.client.api.model.Model;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class SocialJSONDecodingSupport {
  /**
   * Parse JSON text into java Model object from the input source.
   * and then it's base on the class type.
   * 
   * @param <T> Generic type must extend from Model.
   * @param clazz Class type.
   * @param jsonContent Json content which you need to create the Model
   * @throws ParseException Throw this exception if any
   */
  public static <T extends Model> T parser(final Class<T> clazz, String jsonContent) throws ParseException {
    JSONParser parser = new JSONParser();
    ContainerFactory containerFactory = new ContainerFactory() {
      public List<T> creatArrayContainer() {
        return new LinkedList<T>();
      }

      public T createObjectContainer() {
        try {
          return clazz.newInstance();
        } catch (InstantiationException e) {
          return null;
        } catch (IllegalAccessException e) {
          return null;
        }
      }
    };
    return (T) parser.parse(jsonContent, containerFactory);
  }
}