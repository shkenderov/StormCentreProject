/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Uchitelq
 */
public class MainScreen extends JFrame implements ActionListener {
    private Storm temp;
    
    boolean is_help_pressed=false;
    private String windEdit;
    private String tempEdit;
    
    
    private System system;
    private GridBagConstraints constraints;
    
    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblWind;
    private JLabel lblTemp;
    
    private JTextField txtName;
    private JTextField txtWind;
    private JTextField txtTemp;
    private JTextField edit_wind;
    private JTextField edit_temp;
    
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnView;
    private JButton btnHelp;
    private JButton btnEdit;
    private JButton btnConfirm;
    
    private JComboBox<String> cb;
    

    
    String[] choices = { "                         Hurricane","                           Blizzard","                          Tornado"};
    public MainScreen(){
    
    system=new System();
    this.setLayout(new GridBagLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    constraints = new GridBagConstraints();
    
    
    // Set up our components
    initComponents();
		
    // Create layout
    layoutComponents();
    }
    public void initComponents(){
    
     edit_wind=new JTextField();
     edit_temp=new JTextField();
     

        
     lblTitle = new JLabel("STORMS DATABASE");
     lblName=new JLabel("Name:");
     lblWind=new JLabel("Wind Speed:");
     lblTemp=new JLabel("Air Temperature:");
     
     cb= new JComboBox<>(choices);
     
     txtName=new JTextField();
     txtWind=new JTextField();
     txtTemp=new JTextField();
     
    btnAdd = new JButton("Add Storm");
    btnAdd.addActionListener(this);
    btnRemove = new JButton("Remove Storm");
    btnRemove.addActionListener(this);
    btnView=new JButton("  View Info  ");
    btnView.addActionListener(this);
    btnHelp=new JButton("        Help         ");
    btnHelp.addActionListener(this);
    btnEdit=new JButton("        Edit         ");
    btnEdit.addActionListener(this);

     
    }
    public void layoutComponents(){
        constraints.gridy = 0;
        constraints.gridx = 0;
	constraints.gridwidth = 2;
        
        
        this.add(lblTitle, constraints);
        
        constraints.gridy = 1;
        constraints.gridwidth = 1;
	this.add(lblName, constraints);
        
        constraints.gridy = 2;
        this.add(lblWind, constraints);
        
        constraints.gridy = 3;
        this.add(lblTemp, constraints);
        
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cb, constraints);
        
        constraints.gridy = 5;
        constraints.gridwidth = 2;
       
        //this.add(btnEdit, constraints);
        //constraints.gridx=1;
        this.add(btnEdit,constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = 6;
        constraints.gridx = 0; 
        this.add(btnAdd, constraints);

        constraints.gridx = 1; 
        this.add(btnRemove, constraints);
        
	
        constraints.gridy = 3;
	this.add(txtTemp, constraints);  
        
        constraints.gridy = 2;
	this.add(txtWind, constraints);        
        
        constraints.gridy = 1;
	this.add(txtName, constraints);
        
        constraints.gridy = 7;
        constraints.gridx = 0; 
         this.add(btnView, constraints);
        
        constraints.gridx = 1; 
        this.add(btnHelp,constraints);


        
        
    }
    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource().equals(btnAdd)){
            
                if(txtWind.getText().equals("")||txtName.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill in all the required fields.");
                }
                else{
                    if(tryParse(txtWind.getText())==null){
                        JOptionPane.showMessageDialog(null, "Wind is a numeric value");
                        
                    }
                    else if(tryParse(txtWind.getText())<=0) JOptionPane.showMessageDialog(null, "Wind is greater than 0");
                    else if(tryParse(txtTemp.getText())==null&&cb.getSelectedItem().toString().equals("                           Blizzard")){
                        JOptionPane.showMessageDialog(null, "Temperature is a numeric value");
                    }
                    else{
                        if(cb.getSelectedItem().toString().equals("                         Hurricane")){
                            temp=new Hurricane(tryParse(txtWind.getText()),txtName.getText());
                        }
                        else if(cb.getSelectedItem().toString().equals("                          Tornado")){
                            temp=new Tornado(tryParse(txtWind.getText()),txtName.getText());
                        }
                        else if(cb.getSelectedItem().toString().equals("                           Blizzard")){
                            temp=new Blizzard(tryParse(txtTemp.getText()),txtName.getText(),tryParse(txtWind.getText()));
                        }
                        if(system.addStorm(temp))
                            {
                                JOptionPane.showMessageDialog(null, temp.getName()+" has been added\n"+system.view_info(txtName.getText()));
                            }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Database full or this name is already entered");
                        }
                    
                }
            }
        }
        
        
        
        
         if(ev.getSource().equals(btnView)){
            if(txtName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields.");
            }
            else{
                JOptionPane.showMessageDialog(null,system.view_info(txtName.getText()));
            }
        }
         
         
         
        if(ev.getSource().equals(btnRemove)){
            if(system.remove(txtName.getText())){
                JOptionPane.showMessageDialog(null,txtName.getText()+ " has been succesfully removed");
            }
            else  JOptionPane.showMessageDialog(null,"Error removing " +txtName.getText() + ". Please check if this storm has been entered.");
        }
        
        
        if(ev.getSource().equals(btnHelp)){
            JOptionPane.showMessageDialog(null,"To enter a new Tornado or Hurricane in the system you need to input the storm name, wind speed and type(from the drop down menu).\nTo enter a blizzard, the temperature is needed as well.\nTo view a storm only the name is needed.\nTo edit a storm, enter it's name and press edit and fill in the window that pops up");
            is_help_pressed=true;
        }
        
        if(ev.getSource().equals(btnEdit)){
            if(system.search(txtName.getText())!=null){
                temp=system.search(txtName.getText());
                if(temp.temperature==null){
                    windEdit=JOptionPane.showInputDialog(null,"Please enter the new wind speed.\nThe current one is "+temp.getWindSpeed()+" mph.");
                    if(windEdit!=null&&tryParse(windEdit)!=null){
                        temp.setWindSpeed(tryParse(windEdit));
                        JOptionPane.showMessageDialog(null,system.view_info(txtName.getText()));
                    }
                    else JOptionPane.showMessageDialog(null, "Please check your input and try again.");
                }
                else{
                    Object [] Blizzard_Editor={
                    "Wind", edit_wind,
                    "Temperature", edit_temp
                    };
                    JOptionPane.showConfirmDialog(null, Blizzard_Editor , "Enter the new values for the Blizzard",JOptionPane.OK_CANCEL_OPTION );
                    windEdit=edit_wind.getText();
                    tempEdit=edit_temp.getText();
                    if(windEdit==null||tryParse(windEdit)==null){
                        JOptionPane.showMessageDialog(null, "Wind is a numeric value");

                    }
                    else if(tempEdit==null||tryParse(tempEdit)==null){
                        JOptionPane.showMessageDialog(null, "Tempterature is a numeric value");
                    }
                    else{
                        temp.setWindSpeed(tryParse(windEdit));
                        temp.setTemperature(tryParse(tempEdit));
                        JOptionPane.showMessageDialog(null,system.view_info(txtName.getText()));
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Error editing " +txtName.getText() + ". Please check if this storm has been entered.");
            }
        }
    if(!is_help_pressed){    
        txtName.setText("");
        txtWind.setText("");
        txtTemp.setText("");
        edit_wind.setText("");
        edit_temp.setText("");
        }
    else is_help_pressed=false;
    }
    
    
    
    
    public static Integer tryParse(String text) {
      try {
        return Integer.parseInt(text);
      } catch (NumberFormatException e) {
        return null;
      }
    }
}
