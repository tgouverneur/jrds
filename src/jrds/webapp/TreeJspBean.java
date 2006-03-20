/*##########################################################################
 _##
 _##  $Id$
 _##
 _##########################################################################*/

package jrds.webapp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import jrds.GraphTree;
import jrds.HostsList;

/**
 * 
 * @author Fabrice Bacchella
 * @version $Revision$ $Date$
 */
public class TreeJspBean {
	public void getJavascriptTree(int sort, String father, JspWriter out, HttpServletRequest req) throws JspException {
		GraphTree graphTree = null;
		if(sort == GraphTree.LEAF_GRAPHTITLE )
			graphTree = HostsList.getRootGroup().getGraphTreeByHost();
		else if(sort == GraphTree.LEAF_HOSTNAME)
			graphTree = HostsList.getRootGroup().getGraphTreeByView();
		try {
			if(graphTree != null) {
				graphTree.getJavaScriptCode(out, req.getQueryString(), father);
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
			}
	}
}
