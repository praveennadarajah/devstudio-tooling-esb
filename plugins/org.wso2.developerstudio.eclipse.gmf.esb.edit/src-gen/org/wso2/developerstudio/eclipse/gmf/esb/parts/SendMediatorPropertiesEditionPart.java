/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface SendMediatorPropertiesEditionPart {

	/**
	 * @return the skipSerialization
	 * 
	 */
	public Boolean getSkipSerialization();

	/**
	 * Defines a new skipSerialization
	 * @param newValue the new skipSerialization to set
	 * 
	 */
	public void setSkipSerialization(Boolean newValue);




	/**
	 * Init the EndPoint
	 * @param settings settings for the EndPoint ReferencesTable 
	 */
	public void initEndPoint(ReferencesTableSettings settings);

	/**
	 * Update the EndPoint
	 * @param newValue the EndPoint to update
	 * 
	 */
	public void updateEndPoint();

	/**
	 * Adds the given filter to the EndPoint edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEndPoint(ViewerFilter filter);

	/**
	 * Adds the given filter to the EndPoint edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEndPoint(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the EndPoint table
	 * 
	 */
	public boolean isContainedInEndPointTable(EObject element);


	/**
	 * @return the receivingSequenceType
	 * 
	 */
	public Enumerator getReceivingSequenceType();

	/**
	 * Init the receivingSequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initReceivingSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new receivingSequenceType
	 * @param newValue the new receivingSequenceType to set
	 * 
	 */
	public void setReceivingSequenceType(Enumerator newValue);


	/**
	 * @return the buildMessageBeforeSending
	 * 
	 */
	public Boolean getBuildMessageBeforeSending();

	/**
	 * Defines a new buildMessageBeforeSending
	 * @param newValue the new buildMessageBeforeSending to set
	 * 
	 */
	public void setBuildMessageBeforeSending(Boolean newValue);


	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);




	// Start of user code for StaticReceivingSequence specific getters and setters declaration
	public void setStaticReceivingSequence(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getStaticReceivingSequence();
	
	// End of user code
	// Start of user code for DynamicReceivingSequence specific getters and setters declaration
	public void setDynamicReceivingSequence(NamespacedProperty namespacedProperty);
	
	public NamespacedProperty getDynamicReceivingSequence();
	
	// End of user code

	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}