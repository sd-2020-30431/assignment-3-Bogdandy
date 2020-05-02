package client.presentation;

import client.business.CheckList;
import client.business.GroceryItemRequests;
import client.business.ItemChecker;
import client.business.ItemInformation;
import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;

public class GroceryListManagementForm extends javax.swing.JFrame {
    private String reportChoice = "Weekly";
    private int groceryListId = 1;
    private Long id;
    private Integer selectedRowIndex = null;
    private ItemChecker itemChecker;
    private final GroceryItemRequests groceryItemRequests;
    private Timer observerTimer;
    
    public GroceryListManagementForm() {
        initComponents();
        groceryItemRequests = new GroceryItemRequests();
    }
    
    public void setTableList(){
        try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) groceryItemRequests.retrieveListItems(id, groceryListId);
            userGroceryList.setModel(defaultTableModel); 
        } catch (IOException | JSONException | ParseException ex) { 
            JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void setUserID(Long id){
        this.id = id;
        setTableList();
        observerTimer = new Timer();
        observerTimer.schedule(new CheckList(id, groceryItemRequests), 2000, 3600000);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        groceryListScroll = new javax.swing.JScrollPane();
        userGroceryList = new javax.swing.JTable();
        searchPanel = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        itemNameField = new javax.swing.JTextField();
        quantityField = new javax.swing.JTextField();
        calorieValueField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        purchaseDateChooser = new datechooser.beans.DateChooserCombo();
        expirationDateChooser = new datechooser.beans.DateChooserCombo();
        consumptionChooserCombo = new datechooser.beans.DateChooserCombo();
        groceryListOptionsPanel = new javax.swing.JPanel();
        modifyItemButton = new javax.swing.JButton();
        addItemsToGroceryList = new javax.swing.JButton();
        groceryListSelector = new javax.swing.JComboBox<>();
        ClearListButton = new javax.swing.JButton();
        removeItemButton = new javax.swing.JButton();
        reportPanel = new javax.swing.JPanel();
        reportsButton = new javax.swing.JButton();
        reportTypeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WasteLess");

        containerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        userGroceryList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item Id", "Item Name", "Quantity", "Calorie Value", "Purchase Date", "Expiration Date", "Consumption Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }
        });
        userGroceryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userGroceryListMouseClicked(evt);
            }
        });
        groceryListScroll.setViewportView(userGroceryList);

        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchButton)))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(refreshButton))
                .addContainerGap())
        );

        optionsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Item Name");

        jLabel2.setText("Quantity");

        jLabel3.setText("Calorie Value");

        jLabel4.setText("Purchase Date");

        jLabel5.setText("Expiration Date");

        jLabel6.setText("Consumption Date");

        purchaseDateChooser.setCurrentView(new datechooser.view.appearance.AppearancesList("Contrast",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    purchaseDateChooser.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            purchaseDateChooserOnCommit(evt);
        }
    });

    expirationDateChooser.setCurrentView(new datechooser.view.appearance.AppearancesList("Contrast",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));

consumptionChooserCombo.setCurrentView(new datechooser.view.appearance.AppearancesList("Contrast",
    new datechooser.view.appearance.ViewAppearance("custom",
        new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
            new java.awt.Color(0, 0, 0),
            new java.awt.Color(0, 0, 255),
            false,
            true,
            new datechooser.view.appearance.swing.ButtonPainter()),
        new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
            new java.awt.Color(0, 0, 0),
            new java.awt.Color(0, 0, 255),
            true,
            true,
            new datechooser.view.appearance.swing.ButtonPainter()),
        new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
            new java.awt.Color(0, 0, 255),
            new java.awt.Color(0, 0, 255),
            false,
            true,
            new datechooser.view.appearance.swing.ButtonPainter()),
        new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
            new java.awt.Color(128, 128, 128),
            new java.awt.Color(0, 0, 255),
            false,
            true,
            new datechooser.view.appearance.swing.LabelPainter()),
        new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
            new java.awt.Color(0, 0, 0),
            new java.awt.Color(0, 0, 255),
            false,
            true,
            new datechooser.view.appearance.swing.LabelPainter()),
        new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
            new java.awt.Color(0, 0, 0),
            new java.awt.Color(255, 0, 0),
            false,
            false,
            new datechooser.view.appearance.swing.ButtonPainter()),
        (datechooser.view.BackRenderer)null,
        false,
        true)));

groceryListOptionsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

modifyItemButton.setText("Modify Item");
modifyItemButton.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
    modifyItemButtonActionPerformed(evt);
    }
    });

    addItemsToGroceryList.setText("Add to Grocery List");
    addItemsToGroceryList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addItemsToGroceryListActionPerformed(evt);
        }
    });

    groceryListSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
    groceryListSelector.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            groceryListSelectorActionPerformed(evt);
        }
    });

    ClearListButton.setText("Clear List");
    ClearListButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ClearListButtonActionPerformed(evt);
        }
    });

    removeItemButton.setText("Remove Item");
    removeItemButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeItemButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout groceryListOptionsPanelLayout = new javax.swing.GroupLayout(groceryListOptionsPanel);
    groceryListOptionsPanel.setLayout(groceryListOptionsPanelLayout);
    groceryListOptionsPanelLayout.setHorizontalGroup(
        groceryListOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groceryListOptionsPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(groceryListSelector, 0, 105, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(groceryListOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(ClearListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modifyItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(groceryListOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(addItemsToGroceryList)
                .addComponent(removeItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    groceryListOptionsPanelLayout.setVerticalGroup(
        groceryListOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(groceryListOptionsPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(groceryListOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(modifyItemButton)
                .addComponent(addItemsToGroceryList)
                .addComponent(groceryListSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(groceryListOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ClearListButton)
                .addComponent(removeItemButton))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    reportPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    reportsButton.setText("See Report");
    reportsButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            reportsButtonActionPerformed(evt);
        }
    });

    reportTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weekly", "Monthly" }));
    reportTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            reportTypeComboBoxActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
    reportPanel.setLayout(reportPanelLayout);
    reportPanelLayout.setHorizontalGroup(
        reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(reportTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportsButton)
            .addContainerGap())
    );
    reportPanelLayout.setVerticalGroup(
        reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportPanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(reportsButton)
                .addComponent(reportTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
    optionsPanel.setLayout(optionsPanelLayout);
    optionsPanelLayout.setHorizontalGroup(
        optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(optionsPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                    .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(consumptionChooserCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(expirationDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(calorieValueField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(purchaseDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(23, 23, 23))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                    .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(reportPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(groceryListOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())))
    );
    optionsPanelLayout.setVerticalGroup(
        optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(calorieValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(optionsPanelLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jLabel3)))
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(optionsPanelLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel4))
                .addGroup(optionsPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(purchaseDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(optionsPanelLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel5))
                .addGroup(optionsPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(expirationDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
            .addGap(5, 5, 5)
            .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(consumptionChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(groceryListOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(reportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
    containerPanel.setLayout(containerPanelLayout);
    containerPanelLayout.setHorizontalGroup(
        containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(groceryListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    containerPanelLayout.setVerticalGroup(
        containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(containerPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(groceryListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGroup(containerPanelLayout.createSequentialGroup()
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try{
            if(groceryItemRequests.searchGroceryItem(id, groceryListId, searchBar.getText())){
                JOptionPane.showMessageDialog(null, "Item Exists in the Grocey List!");
            }else{
               JOptionPane.showMessageDialog(null, "No Item Found with this Name Exists in the Grocey List!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void purchaseDateChooserOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_purchaseDateChooserOnCommit
        expirationDateChooser.setSelectedDate(purchaseDateChooser.getSelectedDate());
    }//GEN-LAST:event_purchaseDateChooserOnCommit

    private void addItemsToGroceryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemsToGroceryListActionPerformed
        LocalDate purchaseDate = LocalDate.ofInstant(purchaseDateChooser.getSelectedDate().getTime().toInstant(), ZoneId.systemDefault());
        LocalDate expirationDate = LocalDate.ofInstant(expirationDateChooser.getSelectedDate().getTime().toInstant(), ZoneId.systemDefault());
        LocalDate consumptionDate = LocalDate.ofInstant(consumptionChooserCombo.getSelectedDate().getTime().toInstant(), ZoneId.systemDefault());
        
        ItemInformation itemInformation = new ItemInformation(id,itemNameField.getText(), 
                Integer.parseInt(quantityField.getText()),  Integer.parseInt(calorieValueField.getText()), 
                purchaseDate, expirationDate, consumptionDate, groceryListId);
        selectedRowIndex = null;
        
        itemChecker = new ItemChecker(itemInformation);
        if(itemChecker.checkItemInformation()){
            try{
                if(groceryItemRequests.addNewGroceryItem(itemInformation)){
                    setTableList();
                    JOptionPane.showMessageDialog(null, "Item added successfully!");
                }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Item couldn't be added!\nCheck item fields!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addItemsToGroceryListActionPerformed

    private void modifyItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyItemButtonActionPerformed
        if(selectedRowIndex != null){
            LocalDate purchaseDate = LocalDate.ofInstant(purchaseDateChooser.getSelectedDate().getTime().toInstant(), ZoneId.systemDefault());
            LocalDate expirationDate = LocalDate.ofInstant(expirationDateChooser.getSelectedDate().getTime().toInstant(), ZoneId.systemDefault());
            LocalDate consumptionDate = LocalDate.ofInstant(consumptionChooserCombo.getSelectedDate().getTime().toInstant(), ZoneId.systemDefault());

            ItemInformation itemInformation = new ItemInformation(id,itemNameField.getText(), 
                    Integer.parseInt(quantityField.getText()),  Integer.parseInt(calorieValueField.getText()), 
                    purchaseDate, expirationDate, consumptionDate, groceryListId);
            
            itemChecker = new ItemChecker(itemInformation);
            if(itemChecker.checkItemInformation()){
                try{
                    if(groceryItemRequests.modifyGroceryItem(itemInformation, selectedRowIndex)){
                        setTableList();
                        JOptionPane.showMessageDialog(null, "Item modified successfully!");
                    }
                }catch(NumberFormatException| IOException ex){
                    JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Item couldn't be modified!\nCheck item fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_modifyItemButtonActionPerformed

    private void groceryListSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groceryListSelectorActionPerformed
        groceryListId = groceryListSelector.getSelectedIndex() + 1;
        selectedRowIndex = null;
        setTableList();
    }//GEN-LAST:event_groceryListSelectorActionPerformed

    private void userGroceryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userGroceryListMouseClicked
        DefaultTableModel model = (DefaultTableModel)userGroceryList.getModel();
        selectedRowIndex = userGroceryList.getSelectedRow();
        Date d;
        
        try {
            Calendar cal = Calendar.getInstance();
            itemNameField.setText(model.getValueAt(selectedRowIndex, 0).toString());
            quantityField.setText(model.getValueAt(selectedRowIndex, 1).toString());
            calorieValueField.setText(model.getValueAt(selectedRowIndex, 2).toString());
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRowIndex,3).toString()));
            purchaseDateChooser.setSelectedDate(cal);
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRowIndex,4).toString()));
            expirationDateChooser.setSelectedDate(cal);
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRowIndex,5).toString()));
            consumptionChooserCombo.setSelectedDate(cal);
        
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Item couldn't be set!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_userGroceryListMouseClicked

    private void ClearListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearListButtonActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the list?");
        
        if(input == 0){
            try {
                if(groceryItemRequests.clearList(id, groceryListId)){
                    setTableList();
                    selectedRowIndex = null;
                    JOptionPane.showMessageDialog(null, "Grocery list cleared!");
                }else{
                    JOptionPane.showMessageDialog(null, "List is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ClearListButtonActionPerformed

    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        if(selectedRowIndex != null){
            try{
                if(groceryItemRequests.removeGroceryItem(selectedRowIndex)){
                    setTableList();
                    JOptionPane.showMessageDialog(null, "Item removed successfully!");
                }else{
                    JOptionPane.showMessageDialog(null, "Item couldn't be removed!\nCheck item fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            selectedRowIndex = null;
        }
    }//GEN-LAST:event_removeItemButtonActionPerformed

    private void reportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsButtonActionPerformed
        try {
            groceryItemRequests.createReport(id, groceryListId, reportChoice);
        } catch (IOException | JSONException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong!\nService provider may be down!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_reportsButtonActionPerformed

    private void reportTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTypeComboBoxActionPerformed
         reportChoice = reportTypeComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_reportTypeComboBoxActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        setTableList();
        selectedRowIndex = null;
    }//GEN-LAST:event_refreshButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroceryListManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GroceryListManagementForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearListButton;
    private javax.swing.JButton addItemsToGroceryList;
    private javax.swing.JTextField calorieValueField;
    private datechooser.beans.DateChooserCombo consumptionChooserCombo;
    private javax.swing.JPanel containerPanel;
    private datechooser.beans.DateChooserCombo expirationDateChooser;
    private javax.swing.JPanel groceryListOptionsPanel;
    private javax.swing.JScrollPane groceryListScroll;
    private javax.swing.JComboBox<String> groceryListSelector;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton modifyItemButton;
    private javax.swing.JPanel optionsPanel;
    private datechooser.beans.DateChooserCombo purchaseDateChooser;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JComboBox<String> reportTypeComboBox;
    private javax.swing.JButton reportsButton;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable userGroceryList;
    // End of variables declaration//GEN-END:variables
}
