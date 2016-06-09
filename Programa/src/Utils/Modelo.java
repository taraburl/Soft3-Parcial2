/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USUARIO
 */
public class Modelo extends AbstractTableModel{
    private Class[] types;
    private String[] columnNames ;
    private ArrayList<ArrayList<Object>> l_modelo;
    private int items_visible;
    private boolean[] canEdit;
    private HashMap<String, Object> colum_names;
    private int position_numeral;
    
    //**********componentes***************
    private ActionListener listener_button;
    private String ruta_imagen;
    private String[] data_combo;
    private String texto_button;
    
    public Modelo(String[] header, Class[] types, boolean canEdit[],
                  int items_visible, int position_numeral){
        super();
        this.types = types;
        this.columnNames = header;
        this.canEdit = new boolean[canEdit.length];
        System.arraycopy(canEdit, 0, this.canEdit, 0, canEdit.length);
        this.l_modelo = new ArrayList<>();
        this.items_visible = items_visible;
        this.cargarColumNames(header);
        this.position_numeral = position_numeral;
    }
    
    public void setButtonAttributes(ActionListener l, String path, String texto){
        this.ruta_imagen = path;
        this.texto_button = texto;
        this.listener_button = l;
    }
    
    public void setComboBoxAttributes(String V[]){
        data_combo = V;
    }
    
    private void cargarColumNames(String header[]){
        this.colum_names = new HashMap();
        for (int i = 0; i < header.length; i++) {
            colum_names.put(header[i], i);
        }
    }
    
    public int getColumnIndex(String columName){
        return (int)this.colum_names.get(columName);
    }
    
    public void addRow(ArrayList<Object> data){
        l_modelo.add(data);
        fireTableDataChanged();
    }
    
    public void setEditable(boolean valor[]){
        System.arraycopy(valor, 0, canEdit, 0, valor.length);
    }
    
    public void addDataList(ArrayList<ArrayList<Object>> modelo){
        l_modelo.clear();
        l_modelo = (ArrayList<ArrayList<Object>>) modelo.clone();
        fireTableDataChanged();
    }
    
    public void removeRow(int row){
        l_modelo.remove(row);
        fireTableDataChanged();
    }
    
    public void removeModel(){
        l_modelo.clear();
    }
     
    public void addEmptyRowsWithNumbers(int cant_rows, int columns){
        for (int i = 0; i < cant_rows; i++) {
            ArrayList lista = new ArrayList();
            for (int j = 0; j < columns; j++) {
                    switch(types[j].getName()){
                        case "java.lang.Integer"                 : lista.add(null);break;
                        case "java.lang.Boolean"                 : lista.add(Boolean.FALSE);break;                      
                        case "javax.swing.JButton"               : JButton button = new JButton(createImageIcon(ruta_imagen));
                                                                   button.setText(texto_button+" "+l_modelo.size());
                                                                   button.setForeground(Color.WHITE);
                                                                   button.addActionListener(listener_button);
                                                                   lista.add(button);break;
                        case "javax.swing.JComboBox"             : lista.add(new JComboBox<>(data_combo));break;
                        case "java.lang.Double"                  : lista.add(null);break;
                        case "java.lang.String"                  : lista.add(null);break;
                        case "java.lang.Object"                  : lista.add(null);break;
                }
             }
            l_modelo.add(lista);
        }
        fireTableDataChanged();
    }
    
    public boolean validarFila(int row_selected, int cant_colum) {
        int c = 0;
        int i = 0;
        
        if(position_numeral >= 0){
            i = 1;
            c = 1;
        }
        
        for (int j = i; j < cant_colum; j++) {
            switch (types[j].getName()) {
                case "com.toedter.calendar.JDateChooser":
                    c++;
                    break;
                case "javax.swing.JButton":
                    c++;
                    break;
                case "javax.swing.JComboBox":
                    c++;
                    break;
                case "java.lang.Boolean":
                    c++;
                    break;
                default:
                    if (l_modelo.get(row_selected).get(j) != null &&
                        !l_modelo.get(row_selected).get(j).equals("")) {
                        c++;
                    }
                    break;
            }
            
        }

        if (c == cant_colum)
           return true;
        else 
           return false;
        
    }
    
    public boolean ValidarCamposVacios(String columNameValidation, int col_count){
        deleteEmptyRows(col_count);
        
        for (int i = 0; i < getRowCount(); i++) {
            if(getValueAt(i, columNameValidation) == Boolean.FALSE)
                return false;
        }
        
        return true;
    }
    
    public boolean isRowUpdated(int size){
        if(l_modelo.size() > size)
            return false;
        else
            return true;
    }
    
    public boolean isNewRow(int row, ArrayList<ArrayList<Object>> l_modelo_copy){
        if(row >= l_modelo_copy.size())
            return true;
        else
            return false;
    }
    
    public void deleteEmptyRows(int cant_colum) {
        int k = 0;
        
        if(position_numeral >= 0)
            k = 1;
        
        for (int i = l_modelo.size() - 1; i >= 0; i--) {
            int c = 0;
            for (int j = k; j < cant_colum; j++){

                switch (types[j].getName()) {
                    case "com.toedter.calendar.JDateChooser":
                        c++;
                        break;
                    case "javax.swing.JButton":
                        c++;
                        break;
                    case "javax.swing.JComboBox":
                        c++;
                        break; 
                    case "java.lang.Boolean":
                        c++;
                        break;    
                    default:
                        if (l_modelo.get(i).get(j) == null || 
                            l_modelo.get(i).get(j).equals("")) {
                            c++;
                        }
                        break;
                }
            }

            if (c == (cant_colum-k)) {
                l_modelo.remove(i);
                fireTableDataChanged();
            } else {
                return;
            }
        }
    }
    
    
   public int getLastRowwithData(){
        for (int i = l_modelo.size()-1; i >= 0; i--) {
            for (int j = 1; j < items_visible; j++) {
                switch (types[j].getName()) {
                    case "com.toedter.calendar.JDateChooser":
                        break;
                    case "javax.swing.JButton":
                        break;
                    case "javax.swing.JComboBox":
                        break; 
                    case "java.lang.Boolean":
                        break;    
                    default:
                        if (l_modelo.get(i).get(j) != null) {
                            return i;
                        }
                        break;
                }
                
            }
        }
        
        return -1;
    }
    
   
    public Object getValueAt(int rowIndex, String columnIndex) {
        if((int)colum_names.get(columnIndex) == position_numeral)
            return rowIndex + 1;
        return l_modelo.get(rowIndex).get((int)colum_names.get(columnIndex));
    }
   
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return types [columnIndex];  
     }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
          return canEdit [columnIndex];
    }

    @Override
    public int getRowCount() {
        return l_modelo.size();
    }
    
    @Override
    public int getColumnCount() {
        return items_visible;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == position_numeral)
            return rowIndex + 1;
        return l_modelo.get(rowIndex).get(columnIndex);
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col] ;
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if(l_modelo.get(rowIndex).size() > columnIndex)
            l_modelo.get(rowIndex).remove(columnIndex);
        
        l_modelo.get(rowIndex).add(columnIndex, value);
        fireTableCellUpdated(rowIndex, columnIndex); 
    }  
    
    public void setValueAt(Object value, int rowIndex, String columnName){
        int columnIndex = (int)this.colum_names.get(columnName);
        setValueAt(value, rowIndex, columnIndex);
    }
    
    public void addNewRow(int row, int parametro){
        if((row + parametro) > l_modelo.size())
            addEmptyRowsWithNumbers(1, columnNames.length);
    }
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Modelo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public ArrayList<ArrayList<Object>> getModel(){
        return this.l_modelo;
    }

    public Class[] getTypes() {
        return types;
    }

    public String[] getColumnNames() {
        return columnNames;
    }


    public boolean[] getCanEdit() {
        return canEdit;
    }

    
    
}
