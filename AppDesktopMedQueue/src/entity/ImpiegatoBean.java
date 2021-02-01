package entity;

/** Classe che rappresenta l'impiegato ospedaliero. */
public class ImpiegatoBean {

  private String codicefiscale;
  private String password;
  private String nome;
  private String cognome;
  private String dataDiNascita;
  private String indirizzoEmail;
  private String numeroDiTelefono;
  private int idStruttura;

  /** Inizializza un nuovo oggetto ImpiegatoBean. */
  public ImpiegatoBean() {}

  /**
   * Inizializza un nuovo oggetto ImpiegatoBean settando gli attributi.
   *
   * @param codicefiscale codice fiscale dell'impiegato.
   * @param password password d'accesso al sistema dell'impiegato.
   * @param nome nome impiegato.
   * @param cognome cognome impiegato.
   * @param dataDiNascita data di nascita dell'impiegato.
   * @param indirizzoEmail indirizzo email dell'impiegato.
   * @param numeroDiTelefono numero di telefono dell'impiegato.
   * @param idStruttura id della struttura per cui lavaora l'impiegato.
   */
  public ImpiegatoBean(
      String codicefiscale,
      String password,
      String nome,
      String cognome,
      String dataDiNascita,
      String indirizzoEmail,
      String numeroDiTelefono,
      int idStruttura) {
    this.codicefiscale = codicefiscale;
    this.password = password;
    this.nome = nome;
    this.cognome = cognome;
    this.dataDiNascita = dataDiNascita;
    this.indirizzoEmail = indirizzoEmail;
    this.numeroDiTelefono = numeroDiTelefono;
    this.idStruttura = idStruttura;
  }

  /**
   * Metodo che restituisce il codice fiscale dell'impiegato.
   *
   * @return codicefiscale
   */
  public String getCodicefiscale() {
    return codicefiscale;
  }

  /**
   * Metodo per settare un codice fiscale all'oggetto ImpiegatoBean.
   *
   * @param codicefiscale codicefiscale dell'impiegato
   */
  public void setCodicefiscale(String codicefiscale) {
    this.codicefiscale = codicefiscale;
  }

  /**
   * Metodo che restituisce la password dell'impiegato.
   *
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Metodo per settare la password all'oggetto ImpiegatoBean.
   *
   * @param password password dell'impiegato
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Metodo per ottenere il nome del impiegato.
   *
   * @return nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * Metodo per settare il nome all'oggetto ImpiegatoBean.
   *
   * @param nome nome dell'impiegato
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Metodo che ritorna il cognome dell'impiegato.
   *
   * @return cognome
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * Metodo per settare il cognome all'oggetto ImpiegatoBean.
   *
   * @param cognome cognome dell'impiegato
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Metodo per ottenere la data di nascita dell'impiegato.
   *
   * @return data di nascita
   */
  public String getDataDiNascita() {
    return dataDiNascita;
  }

  /**
   * Metodo per settare la data di nascita all'oggetto ImpiegatoBean.
   *
   * @param dataDiNascita data di nascita dell'impiegato
   */
  public void setDataDiNascita(String dataDiNascita) {
    this.dataDiNascita = dataDiNascita;
  }

  /**
   * Metodo per ottenere l'indirizzo email dell'impiegato.
   *
   * @return indirizzo email
   */
  public String getIndirizzoEmail() {
    return indirizzoEmail;
  }

  /**
   * Metodo per settare l'indirizzo email all'oggetto ImpiegatoBean.
   *
   * @param indirizzoEmail indirizzo email dell'impiegato
   */
  public void setIndirizzoEmail(String indirizzoEmail) {
    this.indirizzoEmail = indirizzoEmail;
  }

  /**
   * Metodo per ottenere il numero di telefono dell'impiegato.
   *
   * @return numero di telefono
   */
  public String getNumeroDiTelefono() {
    return numeroDiTelefono;
  }

  /**
   * Metodo per settare il numero di telefono all'oggetto ImpiegatoBean.
   *
   * @param numeroDiTelefono numero di telefondo dell'impiegato
   */
  public void setNumeroDiTelefono(String numeroDiTelefono) {
    this.numeroDiTelefono = numeroDiTelefono;
  }

  /**
   * Metodo per ottenere l'id della struttura dove lavora l'impiegato.
   *
   * @return id della struttura ospedaliera
   */
  public int getIdStruttura() {
    return idStruttura;
  }

  /**
   * Metodo per settare l'id della struttura ospedaliera all'oggetto ImpiegatoBean.
   *
   * @param idStruttura id struttura ospedaliera dell'impeigato
   */
  public void setIdStruttura(int idStruttura) {
    this.idStruttura = idStruttura;
  }
}