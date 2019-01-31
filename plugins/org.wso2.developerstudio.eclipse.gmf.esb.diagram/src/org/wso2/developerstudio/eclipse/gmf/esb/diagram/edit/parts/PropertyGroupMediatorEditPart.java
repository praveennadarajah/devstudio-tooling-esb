package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.PROPERTY_MEDIATOR_ICON_PATH;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.PropertyGroupMediatorSerializer;
import org.apache.synapse.config.xml.PropertyMediatorSerializer;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PropertyMediatorEditPart.PropertyMediatorFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.PropertyGroupMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.PropertyGroupMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.GraphicalValidatorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.MediatorValidationUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyGroupMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.PropertyMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.PropertyGroupMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.PropertyMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * @generated NOT
 */
public class PropertyGroupMediatorEditPart extends FixedSizedAbstractMediator {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3788;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	//	protected IFigure primaryShape;

	/**Œ∏
	* @generated
	*/
	public PropertyGroupMediatorEditPart(View view) {
		super(view);
	}

	/**
	* @generated NOT
	*/
	protected void createDefaultEditPolicies() {
		//		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
		//				new CreationEditPolicyWithCustomReparent(EsbVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PropertyGroupMediatorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new PropertyGroupMediatorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {

		//		FlowLayoutEditPolicy lep = new FlowLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case PropertyGroupMediatorInputConnectorEditPart.VISUAL_ID:
				case PropertyGroupMediatorOutputConnectorEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
				//				return super.createChildEditPolicy(child);
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			//			protected Command createAddCommand(EditPart child, EditPart after) {
			//				return null;
			//			}
			//
			//			protected Command createMoveChildCommand(EditPart child, EditPart after) {
			//				return null;
			//			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return lep;
	}

	protected IFigure createNodeShape() {
		return primaryShape = new PropertyGroupMediatorFigure(new Color(null, 41, 128, 185)) {
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
	//	protected IFigure createNodeShape() {
	//		return primaryShape = new PropertyGroupMediatorFigure();
	//	}

	/**
	* @generated
	*/
	public PropertyGroupMediatorFigure getPrimaryShape() {
		return (PropertyGroupMediatorFigure) primaryShape;
	}

	/**
	* @generated NOT
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		//		if (childEditPart instanceof PropertyMediatorPropertyNameEditPart) {
		//			((PropertyMediatorPropertyNameEditPart) childEditPart)
		//					.setLabel(getPrimaryShape().getFigurePropertyGroupMediatorPropertyValueLabel());
		//			return true;
		//		}
		if (childEditPart instanceof PropertyGroupMediatorDescriptionEditPart) {
			((PropertyGroupMediatorDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigurePropertyGroupMediatorDescriptionLabel());
			return true;
		}
		if (childEditPart instanceof PropertyGroupMediatorInputConnectorEditPart) {
			IFigure borderItemFigure = ((PropertyGroupMediatorInputConnectorEditPart) childEditPart).getFigure();
			//			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.WEST);
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.WEST, 0.5);
			//			getBorderedFigure().getBorderItemContainer()
			//					.add(((PropertyGroupMediatorInputConnectorEditPart) childEditPart).getFigure(), locator);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		if (childEditPart instanceof PropertyGroupMediatorOutputConnectorEditPart) {
			IFigure borderItemFigure = ((PropertyGroupMediatorOutputConnectorEditPart) childEditPart).getFigure();
			//			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.EAST);
			//			getBorderedFigure().getBorderItemContainer()
			//					.add(((PropertyGroupMediatorOutputConnectorEditPart) childEditPart).getFigure(), locator);
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.EAST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyGroupMediatorDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof PropertyGroupMediatorInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((PropertyGroupMediatorInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PropertyGroupMediatorOutputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(((PropertyGroupMediatorOutputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	//	/**
	//	* @generated
	//	*/
	//	protected NodeFigure createNodePlate() {
	//		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
	//		return result;
	//	}

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
		//		figure.setLayoutManager(new StackLayout());
		figure.setLayoutManager(new ToolbarLayout(true));
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
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
	//	public EditPart getPrimaryChildEditPart() {
	//		return getChildBySemanticHint(EsbVisualIDRegistry.getType(PropertyGroupMediatorDescriptionEditPart.VISUAL_ID));
	//	}

	/**
	 * @generated
	 */
	public class PropertyGroupMediatorFigure extends EsbGraphicalShapeWithLabel {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePropertyGroupMediatorPropertyValueLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePropertyGroupMediatorDescriptionLabel;

		/**
		 * @generated
		 */
		public PropertyGroupMediatorFigure(Color borderColor) {

			//			FlowLayout layoutThis = new FlowLayout();
			//			layoutThis.setStretchMinorAxis(false);
			//			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);
			//
			//			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			//			layoutThis.setMajorSpacing(5);
			//			layoutThis.setMinorSpacing(5);
			//			layoutThis.setHorizontal(true);
			//
			//			this.setLayoutManager(layoutThis);
			//
			//			this.setBackgroundColor(THIS_BACK);
			//			createContents();
			super(borderColor, false);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigurePropertyGroupMediatorPropertyValueLabel = new WrappingLabel();

			fFigurePropertyGroupMediatorPropertyValueLabel.setText("<...>");

			//			this.add(fFigurePropertyGroupMediatorPropertyValueLabel);

			//			fFigurePropertyGroupMediatorDescriptionFigure = new WrappingLabel();

			//			fFigurePropertyGroupMediatorDescriptionFigure.setText("<...>");

			//			this.add(fFigurePropertyGroupMediatorDescriptionFigure);
			fFigurePropertyGroupMediatorPropertyValueLabel.setAlignment(SWT.CENTER);
			fFigurePropertyGroupMediatorDescriptionLabel = getPropertyNameLabel();

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePropertyGroupMediatorPropertyValueLabel() {
			return fFigurePropertyGroupMediatorPropertyValueLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePropertyGroupMediatorDescriptionLabel() {
			return fFigurePropertyGroupMediatorDescriptionLabel;
		}

		public String getIconPath() {
			return PROPERTY_MEDIATOR_ICON_PATH;
		}

		public String getNodeName() {
			return Messages.PropertyMediatorEditPart_NodeName;
		}

		public IFigure getToolTip() {
			if (StringUtils.isEmpty(toolTipMessage)) {
				toolTipMessage = Messages.PropertyMediatorEditPart_ToolTipMessage;
			}
			return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
		}

	}

	public void notifyChanged(Notification notification) {
		// this.getModel() will get EMF datamodel of the property mediator datamodel
		if (this.getModel() instanceof CSSNodeImpl) {
			// The following part will check for validation issues with the current data in the model
			CSSNodeImpl model = (CSSNodeImpl) this.getModel();
			if (model.getElement() instanceof PropertyGroupMediatorImpl) {
				PropertyGroupMediatorImpl propertyGroupMediatorDataModel = (PropertyGroupMediatorImpl) model
						.getElement();
				try {
					org.apache.synapse.mediators.builtin.PropertyGroupMediator propertyGroupMediator = PropertyGroupMediatorTransformer
							.createPropertyGroupMediator((EsbNode) propertyGroupMediatorDataModel, true);

					PropertyGroupMediatorSerializer propertyGroupMediatorSerializer = new PropertyGroupMediatorSerializer();
					OMElement omElement = propertyGroupMediatorSerializer
							.serializeSpecificMediator(propertyGroupMediator);

					if (StringUtils
							.isEmpty(MediatorValidationUtil.validateMediatorsFromOEMElement(omElement, "property"))) {
						GraphicalValidatorUtil.removeValidationMark(this);
					} else {
						GraphicalValidatorUtil.addValidationMark(this);
					}
				} catch (JaxenException | SynapseException e) {
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
