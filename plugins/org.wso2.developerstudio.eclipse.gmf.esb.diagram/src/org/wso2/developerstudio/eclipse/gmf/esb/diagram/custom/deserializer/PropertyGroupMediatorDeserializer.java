package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
//import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;


public class PropertyGroupMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, PropertyGroupMediator>{

    @Override
    public PropertyGroupMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {
        Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.PropertyGroupMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());
        
        org.apache.synapse.mediators.builtin.PropertyGroupMediator propertyGroupMediator = (org.apache.synapse.mediators.builtin.PropertyGroupMediator) mediator;
        
        org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator visualLog = (org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator) DeserializerUtils
                .createNode(part, EsbElementTypes.PropertyGroupMediator_3788);
        setElementToEdit(visualLog);
        setCommonProperties(propertyGroupMediator, visualLog);
        
        PropertyMediatorDeserializer propertyMediatorDeserializer = new PropertyMediatorDeserializer();
        
        EList<PropertyMediator> propertyList = new BasicEList<PropertyMediator>();
        for (PropertyMediator propretyMediator : propertyGroupMediator.getPropGroupList()) {
        PropertyMediator propMediator = (PropertyMediator) propertyMediatorDeserializer.createNode(part, propretyMediator);
        propertyList.add(propMediator);
        }
        executeSetValueCommand(PROPERTY_GROUP_MEDIATOR__PROPERTIES, propertyList);
return visualLog;

    }

}
