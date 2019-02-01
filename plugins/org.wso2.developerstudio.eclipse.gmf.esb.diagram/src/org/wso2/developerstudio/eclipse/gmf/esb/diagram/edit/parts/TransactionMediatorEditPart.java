/*
 * Copyright (c) 2014-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.TRANSACTION_MEDIATOR_ICON_PATH;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.TransactionMediatorSerializer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.TransactionMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.TransactionMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.GraphicalValidatorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.MediatorValidationUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.TransactionMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.TransactionMediatorTransformer;

/**
 * @generated NOT
 */
public class TransactionMediatorEditPart extends FixedSizedAbstractMediator {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3521;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    public TransactionMediatorEditPart(View view) {
        super(view);
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new TransactionMediatorItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new TransactionMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // For handle Double click Event.
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
                case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        return primaryShape = new TransactionMediatorFigure(new Color(null, 121, 86, 73)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                }
            };
        };
    }

    /**
     * @generated
     */
    public TransactionMediatorFigure getPrimaryShape() {
        return (TransactionMediatorFigure) primaryShape;
    }

    /**
     * @generated NOT
     */
    protected boolean addFixedChild(EditPart childEditPart) {

        if (childEditPart instanceof TransactionMediatorDescriptionEditPart) {
            ((TransactionMediatorDescriptionEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getTransactionMediatorDescriptionLabel());
            return true;
        }
        if (childEditPart instanceof TransactionMediatorInputConnectorEditPart) {

            IFigure borderItemFigure = ((TransactionMediatorInputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;

        } else if (childEditPart instanceof TransactionMediatorOutputConnectorEditPart) {

            IFigure borderItemFigure = ((TransactionMediatorOutputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);

            return true;
        }
        if (childEditPart instanceof ClassMediatorClassNameEditPart) {
            /*
             * ((ClassMediatorClassNameEditPart) childEditPart)
             * .setLabel(getPrimaryShape()
             * .getFigureClassMediatorPropertyValue());
             */
            return true;
        }
        return false;
    }

    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof TransactionMediatorDescriptionEditPart) {
            return true;
        }
        return false;
    }

    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new ToolbarLayout(true));
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public class TransactionMediatorFigure extends EsbGraphicalShapeWithLabel {

        /**
         * @generated
         */
        private WrappingLabel fFigureTransactionMediatorPropertyValue;

        private WrappingLabel transactionMediatorDescriptionLabel;

        /**
         * @generated
         */
        public TransactionMediatorFigure(Color borderColor) {
            super(borderColor, false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        /**
         * @generated NOT
         */
        private void createContents() {

            fFigureTransactionMediatorPropertyValue = new WrappingLabel();
            fFigureTransactionMediatorPropertyValue.setText(DEFAULT_PROPERTY_VALUE_TEXT);
            fFigureTransactionMediatorPropertyValue.setAlignment(SWT.CENTER);

            transactionMediatorDescriptionLabel = getPropertyNameLabel();
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureTransactionMediatorPropertyValue() {
            return fFigureTransactionMediatorPropertyValue;
        }

        public WrappingLabel getTransactionMediatorDescriptionLabel() {
            return transactionMediatorDescriptionLabel;
        }

        public String getIconPath() {
            return TRANSACTION_MEDIATOR_ICON_PATH;
        }

        public String getNodeName() {
            return Messages.TransactionMediatorEditPart_NodeName;
        }

        public IFigure getToolTip() {
            if (StringUtils.isEmpty(toolTipMessage)) {
                toolTipMessage = Messages.TransactionMediatorEditPart_ToolTipMessage;
            }
            return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
        }

    }

    @Override
    public void notifyChanged(Notification notification) {
        // this.getModel() will get EMF datamodel of the transaction mediator datamodel
        if (this.getModel() instanceof CSSNodeImpl) {
            // The following part will check for validation issues with the current data in the model
            CSSNodeImpl model = (CSSNodeImpl) this.getModel();
            if (model.getElement() instanceof TransactionMediatorImpl) {
                TransactionMediatorImpl transactipnMediatorDataModel = (TransactionMediatorImpl) model.getElement();
                try {
                    org.apache.synapse.mediators.transaction.TransactionMediator transactionMediator = TransactionMediatorTransformer
                            .createTransactionMediator((EsbNode) transactipnMediatorDataModel);

                    TransactionMediatorSerializer transactionMediatorSerializer = new TransactionMediatorSerializer();
                    OMElement omElement = transactionMediatorSerializer.serializeSpecificMediator(transactionMediator);

                    if (StringUtils.isEmpty(
                            MediatorValidationUtil.validateMediatorsFromOEMElement(omElement, "transaction"))) {
                        GraphicalValidatorUtil.removeValidationMark(this);
                    } else {
                        GraphicalValidatorUtil.addValidationMark(this);
                    }
                } catch (SynapseException e) {
                    GraphicalValidatorUtil.addValidationMark(this);
                }
            }
        }
        super.notifyChanged(notification);
    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 230, 230, 230);

}
