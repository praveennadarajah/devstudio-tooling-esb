package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class PropertyGroupMediatorTransformer extends AbstractEsbNodeTransformer {

    @Override
    public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
        try {
            info.getParentSequence().addChild(createPropertyGroupMediator(subject, false));
            // Transform the property mediator output data flow path.
            doTransform(info, ((PropertyGroupMediator) subject).getOutputConnector());
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
        
    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        try {
            sequence.addChild(createPropertyGroupMediator(subject, false));
            doTransformWithinSequence(information, ((PropertyMediator) subject).getOutputConnector().getOutgoingLink(),
                    sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }
    
    public static org.apache.synapse.mediators.builtin.PropertyGroupMediator createPropertyGroupMediator(EsbNode subject, boolean isForValidation)
            throws JaxenException {
        org.apache.synapse.mediators.builtin.PropertyGroupMediator propertyGroupMediator = new org.apache.synapse.mediators.builtin.PropertyGroupMediator();
        PropertyGroupMediator visualProp = (PropertyGroupMediator) subject;
        setCommonProperties(propertyGroupMediator, visualProp);
        List<org.apache.synapse.mediators.builtin.PropertyMediator> propertyList = new ArrayList<>();
        {
            for(PropertyMediator propertyMediator : visualProp.getProperties()) {
                PropertyMediatorTransformer propertyMediatorTransformer = new PropertyMediatorTransformer();
                org.apache.synapse.mediators.builtin.PropertyMediator synapseProperty;
                try {
                    synapseProperty = propertyMediatorTransformer.createPropertyMediator(visualProp, isForValidation);
                    propertyList.add(synapseProperty);
                } catch (XMLStreamException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (TransformerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            propertyGroupMediator.setPropGroupList(propertyList);
        }
        return propertyGroupMediator;
    }
}
