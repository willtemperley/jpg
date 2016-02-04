package org.io.hgis.mapgen.config;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import uk.ac.ox.map.carto.canvas.Rectangle;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by will on 1/23/16.
 */
public class MapConfigDoc {
  protected final XPath xpath;
  protected final Document doc;

  public MapConfigDoc(Document doc) {
    this.doc = doc;
    xpath = XPathFactory.newInstance().newXPath();
  }

  protected ConfigNode getConfigNode(String nodePath) {
    String path = "/mapconf/" + nodePath;
    Node n = getNode(path);
    if (n != null) {
      ConfigNode cn = new ConfigNode(n);
      return cn;
    }
    return null;
  }

  /**
   * Gets a node from the wrapped document
   *
   * @param xpathExpression
   *          The xpath expression
   * @return the node
   */
  protected Node getNode(String xpathExpression) {
    try {
      return (Node) xpath.evaluate(xpathExpression, doc, XPathConstants.NODE);
    } catch (XPathExpressionException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Gets a node from the node passed
   *
   * @param xpathExpression
   *          The xpath expression
   * @return the node
   */
  private Node getNode(String xpathExpression, Node node) {
    try {
      return (Node) xpath.evaluate(xpathExpression, node, XPathConstants.NODE);
    } catch (XPathExpressionException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Convenience method for getting a list of nodes via xpath.
   *
   * @param xpathExpression
   *          The xpath expression
   * @return a newly constructed list of nodes
   */
  protected List<Node> getNodeList(String xpathExpression) {
    try {
      NodeList nodes = (NodeList) xpath.evaluate(xpathExpression, doc,
          XPathConstants.NODESET);
      List<Node> nodeList = new ArrayList<Node>();
      for (int i = 0; i < nodes.getLength(); i++) {
        nodeList.add(nodes.item(i));
      }
      return nodeList;
    } catch (XPathExpressionException e) {
      e.printStackTrace();
      return null;
    }
  }

  public class ConfigNode {

    private final Map<String, String> atts;
    private final Node node;

    public ConfigNode(Node n) {
      this.node = n;
      this.atts = getAttributeMap(n);
    }

    public String getAttribute(String attr) {
      return atts.get(attr);
    }

    /**
     * Convenience method for obtaining a map of attribute name, value pairs.
     *
     * @param node
     * @return a newly constructed map of attributes
     */
    private Map<String, String> getAttributeMap(Node node) {
      Map<String, String> attrMap = new HashMap<String, String>();
      NamedNodeMap attrs = node.getAttributes();
      for (int i = 0; i < attrs.getLength(); i++) {
        node = attrs.item(i);
        attrMap.put(node.getNodeName(), node.getNodeValue());
      }
      return attrMap;
    }

    /**
     * Convenience method for obtaining a rectangle from a rectangle node.
     *
     * @return a new rectangle
     */
    public Rectangle getFrame() {

      Node frameNode = getNode("frame", node);

      NamedNodeMap attrs = frameNode.getAttributes();

      double top = Double.valueOf(attrs.getNamedItem("top").getNodeValue());
      double left = Double.valueOf(attrs.getNamedItem("left").getNodeValue());
      double width = Double.valueOf(attrs.getNamedItem("width").getNodeValue());
      double height = Double.valueOf(attrs.getNamedItem("height").getNodeValue());

      Rectangle rect = new Rectangle(left, top, width, height);
      return rect;
    }
  }
}
