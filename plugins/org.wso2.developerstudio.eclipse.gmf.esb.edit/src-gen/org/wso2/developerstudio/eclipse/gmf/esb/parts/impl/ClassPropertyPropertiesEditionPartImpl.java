/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ClassPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ClassPropertyPropertiesEditionPart {

	protected Text propertyName;
	protected EMFComboViewer propertyValueType;
	protected Text propertyValue;
	// Start of user code  for propertyExpression widgets declarations
    protected NamespacedProperty propertyExpression;
    protected Text propertyExpressionText;
    protected Control[] propertyExpressionTypeElements;
    protected Control[] propertyNameElements;
    protected Control[] propertyValueTypeElements;
    protected Control[] propertyValueElements;
    Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ClassPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence classPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = classPropertyStep.addStep(EsbViewsRepository.ClassProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyValue);
		propertiesStep.addStep(EsbViewsRepository.ClassProperty.Properties.propertyExpression);
		
		
		composer = new PartComposer(classPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ClassProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ClassProperty.Properties.propertyName) {
					return createPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.ClassProperty.Properties.propertyValueType) {
					return createPropertyValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ClassProperty.Properties.propertyValue) {
					return createPropertyValueText(parent);
				}
				// Start of user code for propertyExpression addToPart creation
                if (key == EsbViewsRepository.ClassProperty.Properties.propertyExpression) {
                    return createPropertyExpressionText(parent);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

    /**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.ClassPropertyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createPropertyNameText(Composite parent) {
	    Control propertyNameText = createDescription(parent, EsbViewsRepository.ClassProperty.Properties.propertyName, EsbMessages.ClassPropertyPropertiesEditionPart_PropertyNameLabel);
		propertyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.ClassProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
			}

		});
		propertyName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.ClassProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}

		});
		EditingUtils.setID(propertyName, EsbViewsRepository.ClassProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		Control propertyNameHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ClassProperty.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText
		propertyNameElements = new Control[] { propertyNameText, propertyName, propertyNameHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createPropertyValueTypeEMFComboViewer(Composite parent) {
	    Control propertyValueTypeLabel = createDescription(parent, EsbViewsRepository.ClassProperty.Properties.propertyValueType, EsbMessages.ClassPropertyPropertiesEditionPart_PropertyValueTypeLabel);
		propertyValueType = new EMFComboViewer(parent);
		propertyValueType.setContentProvider(new ArrayContentProvider());
		propertyValueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValueType.getCombo().setLayoutData(propertyValueTypeData);
		propertyValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.ClassProperty.Properties.propertyValueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyValueType()));
				validate();
			}

		});
		propertyValueType.setID(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		Control propertyValueTypeHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ClassProperty.Properties.propertyValueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueTypeEMFComboViewer
		propertyValueTypeElements = new Control[] { propertyValueTypeLabel, propertyValueType.getCombo(),
                propertyValueTypeHelp };
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createPropertyValueText(Composite parent) {
	    Control propertyValueTextLabel = createDescription(parent, EsbViewsRepository.ClassProperty.Properties.propertyValue, EsbMessages.ClassPropertyPropertiesEditionPart_PropertyValueLabel);
		propertyValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValue.setLayoutData(propertyValueData);
		propertyValue.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.ClassProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
			}

		});
		propertyValue.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.ClassProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}

		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.ClassProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		Control propertyValueHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ClassProperty.Properties.propertyValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueText
		propertyValueElements = new Control[] { propertyValueTextLabel, propertyValue, propertyValueHelp };
		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#getPropertyValueType()
	 * 
	 */
	public Enumerator getPropertyValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#initPropertyValueType(Object input, Enumerator current)
	 */
	public void initPropertyValueType(Object input, Enumerator current) {
		propertyValueType.setInput(input);
		propertyValueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#setPropertyValueType(Enumerator newValue)
	 * 
	 */
	public void setPropertyValueType(Enumerator newValue) {
		propertyValueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyValueType);
		if (eefElementEditorReadOnlyState && propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(false);
			propertyValueType.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValueType.isEnabled()) {
			propertyValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ClassPropertyPropertiesEditionPart#setPropertyValue(String newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ClassProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.ClassProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}	
		
	}






	// Start of user code for propertyExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getPropertyExpression() {
        return propertyExpression;
    }

    @Override
    public void setPropertyExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            propertyExpressionText.setText(nameSpacedProperty.getPropertyValue());
            propertyExpression = nameSpacedProperty;
        }
        
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ClassProperty_Part_Title;
	}



	// Start of user code additional methods
    protected Composite createPropertyExpressionText(final Composite parent) {
        Control propertyExpressionTextLabel = createDescription(parent,
                EsbViewsRepository.ClassProperty.Properties.propertyExpression,
                EsbMessages.ClassPropertyPropertiesEditionPart_PropertyExpressionLabel);
        if (propertyExpression == null) {
            propertyExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        propertyExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER); // $NON-NLS-1$
        GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
        propertyExpressionText.setLayoutData(propertyValueData);

        EditingUtils.setID(propertyExpressionText, EsbViewsRepository.ClassProperty.Properties.propertyExpression);
        EditingUtils.setEEFtype(propertyExpressionText, "eef::Text"); //$NON-NLS-1$
        Control propertyExpressionHelp = SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.ClassProperty.Properties.propertyExpression, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createPropertyValueText
        propertyExpressionTypeElements = new Control[] { propertyExpressionTextLabel, propertyExpressionText,
                propertyExpressionHelp };// mouse
        propertyExpressionText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                openPropertyExpressionNSPEDialog(parent);
            }

            @Override
            public void mouseUp(MouseEvent e) {
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
            }

        });

        propertyExpressionText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character != SWT.CR) {
                    openPropertyExpressionNSPEDialog(parent);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        return parent;
    }

    public void openPropertyExpressionNSPEDialog(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                propertyExpression);
        nspd.open();
        propertyExpressionText.setText(propertyExpression.getPropertyValue());
        propertiesEditionComponent
                .firePropertiesChanged(new PropertiesEditionEvent(ClassPropertyPropertiesEditionPartImpl.this,
                        EsbViewsRepository.ClassProperty.Properties.propertyExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getPropertyExpression()));
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {

        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });

        eu.showEntry(propertyNameElements, false);
        eu.showEntry(propertyValueTypeElements, false);

        if (getPropertyValueType() != null
                && getPropertyValueType().getName().equals(PropertyValueType.LITERAL.getName())) {
            eu.showEntry(propertyValueElements, false);
        } else if (getPropertyValueType() != null
                && getPropertyValueType().getName().equals(PropertyValueType.EXPRESSION.getName())) {
            eu.showEntry(propertyExpressionTypeElements, false);

        }

        view.layout(true, true);
    }
	// End of user code


}
