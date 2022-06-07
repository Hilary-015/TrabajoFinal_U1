package Vista;

import Controlador.PeliculasController.Peli;
import Controlador.PeliculasController.PeliculaController;
import Controlador.RatingsController.RatingsController;
import Controlador.RatingsController.RatingsD;
import Vista.Tablas.TablaPeliculas;
import Vista.Tablas.TablaPeliculasMasDatos;
import Vista.Tablas.TablaRatings;
import javax.swing.JOptionPane;

/**
 *
 * @author Hilary Calva
 */
public class FrmPrincipal extends javax.swing.JFrame {

    PeliculaController ctrlPeli = new PeliculaController();
    TablaPeliculas tP = new TablaPeliculas();
    TablaRatings tR = new TablaRatings();
    TablaPeliculasMasDatos tPD = new TablaPeliculasMasDatos();
    RatingsController ctrlRatings = new RatingsController();

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }
    
    /**
     * Metodo que permite guardar los datos de la pelicula ingresados
     */

    public void guardar() {
        if (!txtTitulo.getText().trim().isEmpty() && !txtAnio.getText().trim().isEmpty() && !txtActores.getText().trim().isEmpty()
                && !txtCalificacion.getText().trim().isEmpty() && !txtDirector.getText().trim().isEmpty() && !txtDuracion.getText().trim().isEmpty()
                && !txtEstreno.getText().trim().isEmpty() && !txtGenero.getText().trim().isEmpty() && !txtGuionistas.getText().trim().isEmpty()
                && !txtIdioma.getText().trim().isEmpty() && !txtPais.getText().trim().isEmpty() && !txtPremios.getText().trim().isEmpty()
                && !txtTrama.getText().trim().isEmpty() && !txtBid.getText().trim().isEmpty() && !txtVotes.getText().trim().isEmpty() && !txtTipo.getText().trim().isEmpty()
                && !txtDVD.getText().trim().isEmpty() && !txtBox.getText().trim().isEmpty() && !txtProduccion.getText().trim().isEmpty() && !txtWeb.getText().trim().isEmpty()
                && !txtResponse.getText().trim().isEmpty()) {

            ctrlPeli.getMiPeli().setTitle(txtTitulo.getText());
            ctrlPeli.getMiPeli().setYear(Short.valueOf(txtAnio.getText()));
            ctrlPeli.getMiPeli().setRated(txtCalificacion.getText());
            ctrlPeli.getMiPeli().setReleased(txtEstreno.getText());
            ctrlPeli.getMiPeli().setRuntime(txtDuracion.getText());
            ctrlPeli.getMiPeli().setGenre(txtGenero.getText());
            ctrlPeli.getMiPeli().setDirector(txtDirector.getText());
            ctrlPeli.getMiPeli().setWriter(txtGuionistas.getText());
            ctrlPeli.getMiPeli().setActors(txtActores.getText());
            ctrlPeli.getMiPeli().setPlot(txtTrama.getText());
            ctrlPeli.getMiPeli().setLanguage(txtIdioma.getText());
            ctrlPeli.getMiPeli().setCountry(txtPais.getText());
            ctrlPeli.getMiPeli().setAwards(txtPremios.getText());
            ctrlPeli.getMiPeli().setPoster(txtPublicacion.getText());
            ctrlPeli.getMiPeli().setCola(ctrlRatings.getColaRatings());
            ctrlPeli.getMiPeli().setMetascore(ctrlRatings.getColaRatings().obtenerDato(2).getValue());
            ctrlPeli.getMiPeli().setImdbRating(ctrlRatings.getColaRatings().obtenerDato(0).getValue());
            ctrlPeli.getMiPeli().setImdbVotes(txtVotes.getText());
            ctrlPeli.getMiPeli().setImdbID(txtBid.getText());
            ctrlPeli.getMiPeli().setTipo(txtTipo.getText());
            ctrlPeli.getMiPeli().setDVD(txtDVD.getText());
            ctrlPeli.getMiPeli().setBoxOffice(txtBox.getText());
            ctrlPeli.getMiPeli().setProduction(txtProduccion.getText());
            ctrlPeli.getMiPeli().setWebsite(txtWeb.getText());
            ctrlPeli.getMiPeli().setResponse(txtResponse.getText());

            Peli peli = new Peli(ctrlPeli.getMiPeli().getTitle(), ctrlPeli.getMiPeli().getYear(), ctrlPeli.getMiPeli().getRated(), ctrlPeli.getMiPeli().getReleased(), ctrlPeli.getMiPeli().getRuntime(),
                    ctrlPeli.getMiPeli().getGenre(), ctrlPeli.getMiPeli().getDirector(), ctrlPeli.getMiPeli().getWriter(), ctrlPeli.getMiPeli().getActors(), ctrlPeli.getMiPeli().getPlot(), ctrlPeli.getMiPeli().getLanguage(),
                    ctrlPeli.getMiPeli().getCountry(), ctrlPeli.getMiPeli().getAwards(), ctrlPeli.getMiPeli().getPoster(), ctrlPeli.getMiPeli().getCola(), ctrlPeli.getMiPeli().getMetascore(), ctrlPeli.getMiPeli().getImdbRating(),
                    ctrlPeli.getMiPeli().getImdbVotes(), ctrlPeli.getMiPeli().getImdbID(), ctrlPeli.getMiPeli().getTipo(), ctrlPeli.getMiPeli().getDVD(), ctrlPeli.getMiPeli().getBoxOffice(), ctrlPeli.getMiPeli().getProduction(),
                    ctrlPeli.getMiPeli().getWebsite(), ctrlPeli.getMiPeli().getResponse());

            if (ctrlPeli.getListaPeliculas().insertarAlInicio(peli)) {
                JOptionPane.showMessageDialog(null, "Guardado con éxito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido guardar");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }
    }
    /**
     * Metodo que permite guardar los ratings de cada pelicula
     */

    public void ratings() {
        try {
            if (!txtSource.getText().trim().isEmpty() && !txtPuntuacion.getText().trim().isEmpty()) {
                ctrlRatings.getRatings().setSource(txtSource.getText());
                ctrlRatings.getRatings().setValue(txtPuntuacion.getText());
                RatingsD miRating = new RatingsD(ctrlRatings.getRatings().getSource(), ctrlRatings.getRatings().getValue());
                if (ctrlRatings.getColaRatings().queue(miRating)) {
                    JOptionPane.showMessageDialog(null, "Guardado con éxito");
                    cargarTablaRatings();
                } else {
                    JOptionPane.showMessageDialog(null, "Ratings llenos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campos vacios");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

    }
    
    /**
     * Metodo que permite renovar la cola cuando esta llega a su tope
     */

    public void guardarRatings() {
        try {
            if (ctrlRatings.getColaRatings().getSize() == 3) {
                ctrlRatings = new RatingsController();
                ratings();
            } else {
                ratings();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

    }

    public void limpiar() {
        txtActores.setText("");
        txtAnio.setText("");
        txtCalificacion.setText("");
        txtDirector.setText("");
        txtDuracion.setText("");
        txtEstreno.setText("");
        txtGenero.setText("");
        txtGuionistas.setText("");
        txtIdioma.setText("");
        txtPais.setText("");
        txtPremios.setText("");
        txtPublicacion.setText("");
        txtTitulo.setText("");
        txtTrama.setText("");
        txtVotes.setText("");
        txtBid.setText("");
        txtTipo.setText("");
        txtDVD.setText("");
        txtBox.setText("");
        txtProduccion.setText("");
        txtWeb.setText("");
        txtResponse.setText("");

        cargarTabla();
        cargarTablaMasDatos();
    }
    
    /**
     * Metodo que permite cargar la tabla con algunos datos de las pelciulas
     */

    private void cargarTabla() {

        tP.setListaPeliculas(ctrlPeli.getListaPeliculas());
        tblPeliculas.setModel(tP);
        tblPeliculas.updateUI();
    }

    /**
     * Metodo que permite cargar la tabla de datos restantes de las pelciulas
     */
    private void cargarTablaMasDatos() {

        tPD.setListaPeliculas(ctrlPeli.getListaPeliculas());
        tblPeli.setModel(tPD);
        tblPeli.updateUI();
    }
    
    /**
     * Metodo que permite cargar los ratings que se van ingresando
     */

    private void cargarTablaRatings() {
        tR.setListaRatings(ctrlRatings.getColaRatings());
        tblRatings.setModel(tR);
        tblRatings.updateUI();
    }
    
    /**
     * Metodo que permite cargar los ratings de la pelicula seleccionada según la fila de la tabla 
     */

    private void cargarTablaRatingsPelicula(int seleccion) {
        tR.setListaRatings(ctrlPeli.getListaPeliculas().obtenerDato(seleccion).getCola());
        tblPeliRatings.setModel(tR);
        tblPeliRatings.updateUI();
    }
    
    /**
     * Metodo que permite cargar la trama de la pelicula seleccionada según la fila de la tabla 
     */
    
    private void cargarTrama(int seleccion){
        txtTramaVer.setText(ctrlPeli.getListaPeliculas().obtenerDato(seleccion).getPlot());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        txtCalificacion = new javax.swing.JTextField();
        txtEstreno = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtDirector = new javax.swing.JTextField();
        txtGuionistas = new javax.swing.JTextField();
        txtActores = new javax.swing.JTextField();
        txtIdioma = new javax.swing.JTextField();
        txtPremios = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTrama = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnIngresarRatings = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRatings = new javax.swing.JTable();
        btnGenerarJson = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtPuntuacion = new javax.swing.JTextField();
        txtSource = new javax.swing.JTextField();
        txtPublicacion = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtVotes = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPeliRatings = new javax.swing.JTable();
        txtBid = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtDVD = new javax.swing.JTextField();
        txtBox = new javax.swing.JTextField();
        txtProduccion = new javax.swing.JTextField();
        txtWeb = new javax.swing.JTextField();
        txtResponse = new javax.swing.JTextField();
        btnVerRatings = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPeli = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        btnVerTrama = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTramaVer = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 240, 30));

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 29, 2));
        jLabel3.setText("DATOS PELICULAS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 280, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(63, 33, 4));
        jLabel4.setText("Response:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(63, 33, 4));
        jLabel5.setText("Título: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(63, 33, 4));
        jLabel6.setText("Año:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 50, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 33, 4));
        jLabel7.setText("Clasificación");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 70, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 33, 4));
        jLabel8.setText("Estreno: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(63, 33, 4));
        jLabel9.setText("Duración:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 70, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(63, 33, 4));
        jLabel10.setText("Genero:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 70, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(63, 33, 4));
        jLabel11.setText("Director:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(63, 33, 4));
        jLabel12.setText("Guionistas:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 70, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(63, 33, 4));
        jLabel13.setText("Actores:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 70, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(63, 33, 4));
        jLabel14.setText("Trama:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 70, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(63, 33, 4));
        jLabel15.setText("Idioma:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(63, 33, 4));
        jLabel17.setText("Calificación:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 70, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 33, 4));
        jLabel18.setText("Premios:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 70, 30));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 230, 30));
        jPanel1.add(txtCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 240, 30));
        jPanel1.add(txtEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 240, 30));
        jPanel1.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 230, 30));
        jPanel1.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 240, 30));
        jPanel1.add(txtDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 240, 30));

        txtGuionistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuionistasActionPerformed(evt);
            }
        });
        jPanel1.add(txtGuionistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 230, 30));
        jPanel1.add(txtActores, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 240, 30));
        jPanel1.add(txtIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 240, 30));
        jPanel1.add(txtPremios, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 240, 30));
        jPanel1.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 230, 30));

        txtTrama.setColumns(20);
        txtTrama.setRows(5);
        jScrollPane1.setViewportView(txtTrama);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 240, 60));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 110, 30));

        btnIngresarRatings.setText("INGRESAR");
        btnIngresarRatings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarRatingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarRatings, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 110, 30));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(58, 30, 2));
        jLabel21.setText("RATINGS DE PELICULAS");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, 30));

        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblPeliculas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 990, 90));

        tblRatings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblRatings);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 270, 80));

        btnGenerarJson.setText("JSON");
        btnGenerarJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarJsonActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarJson, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 920, 90, 30));

        jLabel22.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(58, 30, 2));
        jLabel22.setText("TRAMA");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 830, -1, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(63, 33, 4));
        jLabel23.setText("País:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 70, 30));
        jPanel1.add(txtPuntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 210, 30));
        jPanel1.add(txtSource, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 210, 30));
        jPanel1.add(txtPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 240, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(63, 33, 4));
        jLabel25.setText("Publicación:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(63, 33, 4));
        jLabel24.setText("Source:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 70, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(63, 33, 4));
        jLabel28.setText("IMDBVotes:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(63, 33, 4));
        jLabel29.setText("IMDBID:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 80, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(63, 33, 4));
        jLabel30.setText("Tipo:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 80, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(63, 33, 4));
        jLabel31.setText("DVD:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 80, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(63, 33, 4));
        jLabel32.setText("BoxOffice:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 80, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(63, 33, 4));
        jLabel33.setText("Producción:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 80, 30));
        jPanel1.add(txtVotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 240, 30));

        tblPeliRatings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblPeliRatings);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 810, 400, 90));
        jPanel1.add(txtBid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 240, 30));
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 240, 30));
        jPanel1.add(txtDVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 170, 30));
        jPanel1.add(txtBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 170, 30));
        jPanel1.add(txtProduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 170, 30));
        jPanel1.add(txtWeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 240, 30));
        jPanel1.add(txtResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 240, 30));

        btnVerRatings.setText("Ver ");
        btnVerRatings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRatingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerRatings, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 870, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(60, 31, 3));
        jLabel26.setText("Para ver los ratings o trama de cada pelicula seleccione una fila de la tabla 1");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jLabel37.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(58, 30, 2));
        jLabel37.setText("PELÍCULAS INGRESADAS");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, -1, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(63, 33, 4));
        jLabel34.setText("WebSite:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 80, 30));

        tblPeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblPeli);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 990, 90));

        jLabel39.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(58, 30, 2));
        jLabel39.setText("RATINGS");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 830, -1, 30));

        btnVerTrama.setText("Ver");
        btnVerTrama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTramaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerTrama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 870, -1, -1));

        txtTramaVer.setEditable(false);
        txtTramaVer.setColumns(20);
        txtTramaVer.setRows(5);
        jScrollPane6.setViewportView(txtTramaVer);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 810, 270, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 560, 320));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 560, 200));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(49, 28, 8));
        jLabel38.setText("Revise los datos y luego presione el botón");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, 240, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(49, 28, 8));
        jLabel27.setText("Se permite un total de tres ingresos de ratings");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 350, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 560, 280));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 280));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 460, 350));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 460, 410));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 740, 460, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuionistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuionistasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuionistasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnIngresarRatingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarRatingsActionPerformed
        guardarRatings();
    }//GEN-LAST:event_btnIngresarRatingsActionPerformed

    private void btnGenerarJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarJsonActionPerformed
        ctrlPeli.generarGson(ctrlPeli.getListaPeliculas(), "JSON");
    }//GEN-LAST:event_btnGenerarJsonActionPerformed

    private void btnVerRatingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRatingsActionPerformed
        cargarTablaRatingsPelicula(tblPeliculas.getSelectedRow());
    }//GEN-LAST:event_btnVerRatingsActionPerformed

    private void btnVerTramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTramaActionPerformed
        cargarTrama(tblPeliculas.getSelectedRow());
    }//GEN-LAST:event_btnVerTramaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarJson;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngresarRatings;
    private javax.swing.JButton btnVerRatings;
    private javax.swing.JButton btnVerTrama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblPeli;
    private javax.swing.JTable tblPeliRatings;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTable tblRatings;
    private javax.swing.JTextField txtActores;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBid;
    private javax.swing.JTextField txtBox;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtDVD;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtEstreno;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtGuionistas;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPremios;
    private javax.swing.JTextField txtProduccion;
    private javax.swing.JTextField txtPublicacion;
    private javax.swing.JTextField txtPuntuacion;
    private javax.swing.JTextField txtResponse;
    private javax.swing.JTextField txtSource;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextArea txtTrama;
    private javax.swing.JTextArea txtTramaVer;
    private javax.swing.JTextField txtVotes;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
