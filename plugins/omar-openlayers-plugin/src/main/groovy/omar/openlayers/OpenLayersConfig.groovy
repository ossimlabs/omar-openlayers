package omar.openlayers

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding
import org.springframework.core.convert.converter.Converter
import groovy.transform.ToString

/**
 * Created by sbortman on 12/24/16.
 */
@ConfigurationProperties(prefix="omar.openlayers", merge=false)
@ToString(includeNames=true)
class OpenLayersConfig
{
//  Set<OpenLayersLayer> baseMaps;
//  Set<OpenLayersLayer> overlayLayers
  ArrayList<OpenLayersLayer> baseMaps = new ArrayList<OpenLayersLayer>()
  ArrayList<OpenLayersLayer> overlayLayers = new ArrayList<OpenLayersLayer>()

  @ToString(includeNames=true)
  static class OpenLayersLayer {
    String layerType
    String title
    String url
    HashMap<String,String> params = new HashMap<String,String>()
    HashMap<String,Object> options = new HashMap<String,String>()
  }

  @ConfigurationPropertiesBinding
  static class OpenLayersLayerConverter implements Converter<Map<String, String>, OpenLayersLayer>
  {

    @Override
    OpenLayersLayer convert(Map<String, String> map)
    {
      return new OpenLayersLayer( map )
    }
  }
}
