package com.roufid.tutorials.bridge;

import javax.faces.context.FacesContext;
import javax.portlet.RenderRequest;
import javax.portlet.faces.BridgePublicRenderParameterHandler;

/**
 * Public render parameters bridge handler.
 * 
 * @author Radouane ROUFID.
 *
 */
public class CarBridgePublicRenderParameterHandler implements BridgePublicRenderParameterHandler {

	@Override
	public void processUpdates(FacesContext facesContext) {
		
		RenderRequest req = (RenderRequest) facesContext.getExternalContext().getRequest();
		
		String carId = req.getParameter("carId");
		
		// Process your public render parameters here... 
	}

}
