package classes.controller;

import classes.controller.exception.ErrorNewObjectException;
import classes.controller.exception.InvalidKeyException;
import classes.controller.exception.ObjectNotFoundException;
import classes.model.bean.entity.OperazioneBean;
import classes.model.dao.OperazioneModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/** Classe per controllare i metodi del Model di Operazione. */
@RestController
public class OperazioneController {

  private final OperazioneModel operazioneModel = new OperazioneModel();

  /**
   * Metodo che permette di utilizzare il prelevamento per id dell'OperazioneModel.
   *
   * @param body corpo della richiesta preso in input
   * @return Operazione avente l'id passato
   * @throws SQLException per problemi di esecuzione della query
   * @throws ObjectNotFoundException per problemi di oggetto non trovato
   * @throws InvalidKeyException per problemi di chiave primaria
   */
  @PostMapping(value = "/operazione/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
          consumes = MediaType.APPLICATION_JSON_VALUE)
  public OperazioneBean getOperazioneById(@RequestBody String body)
      throws SQLException, ObjectNotFoundException, InvalidKeyException {
    JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
    String id = jsonObject.get("idOperazioneGet").getAsString();

    if (! id.equals("0")) {
      OperazioneBean op = operazioneModel.doRetrieveByKey(Integer.valueOf(id));
      if (op != null) {
        return op;
      } else {
        throw new ObjectNotFoundException(op);
      }
    } else {
      throw new InvalidKeyException("Id invalido, occorre un id maggiore di 0");
    }
  }

  /**
   * Metodo che permette di utilizzare il prelevamento di tutti gli oggetti dell'OperazioneModel.
   *
   * @param body corpo della richiesta preso in input
   * @return Collezione di Operazioni
   * @throws SQLException per problemi di esecuzione della query
   */
  @PostMapping(value = "/operazioni", produces = MediaType.APPLICATION_JSON_VALUE,
          consumes = MediaType.APPLICATION_JSON_VALUE)
  public Collection<OperazioneBean> getAllOperazioni(@RequestBody String body) throws
          SQLException {
    JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
    if(!body.equals("{}")) {
      String order = jsonObject.get("ordineOperazioni").getAsString();
      return operazioneModel.doRetrieveAll(order);
    }else{
      String order ="";
      return operazioneModel.doRetrieveAll(order);
    }
  }

  /**
   * Metodo che permette di utilizzare l'inserimento di una nuova operazione tramite
   * OperazioneModel.
   *
   * @param body corpo della richiesta preso in input
   * @throws SQLException per problemi di esecuzione della query
   */
  @PostMapping(value = "/newOperazione", produces = MediaType.APPLICATION_JSON_VALUE,
          consumes = MediaType.APPLICATION_JSON_VALUE)
  public boolean newOperazione(@RequestBody String body) throws SQLException,
          ErrorNewObjectException {

    JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();

    String tipoOp = jsonObject.get("newOperazioneTipoOp").getAsString();
    String descrizione = jsonObject.get("newOperazioneDesc").getAsString();

    Boolean checkTipoOp = tipoOp.matches("[a-z A-Z]+$");
    Boolean checkDesc = descrizione.matches("[a-z A-Z]+$");
    if (checkDesc && checkTipoOp) {
      operazioneModel.doSave(new OperazioneBean(tipoOp, descrizione));
      return true;
    } else {
      throw new ErrorNewObjectException(new OperazioneBean());
    }
  }

  /**
   * Metodo che permette di utilizzare l'eliminazione di un operazione presente sul DB tramite
   * OperazioneModel.
   *
   * @param body corpo della richiesta preso in input
   * @throws SQLException per problemi di esecuzione della query
   */
  @PostMapping(value = "/deleteOperazione", produces = MediaType.APPLICATION_JSON_VALUE,
          consumes = MediaType.APPLICATION_JSON_VALUE)
  public void deleteOperazione(@RequestBody String body) throws SQLException {
    JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
    String id = jsonObject.get("idOperazioneRemove").getAsString();
    operazioneModel.doDelete(operazioneModel.doRetrieveByKey(Integer.valueOf(id)));
  }

  /**
   * Metodo che permette di utilizzare l'aggiornamento di un operazione presente sul DB tramite
   * OperazioneModel.
   *
   * @param body corpo della richiesta preso in input
   * @throws SQLException per problemi di esecuzione della query
   * @return conferma/non conferma dell'aggiornamento dell'operazione
   */
  @PostMapping(value = "/updateOperazione", produces = MediaType.APPLICATION_JSON_VALUE,
          consumes = MediaType.APPLICATION_JSON_VALUE)
  public boolean updateOperazione(@RequestBody String body) throws SQLException {

    JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();

    String tipoOp = jsonObject.get("updateOperazioneTipoOp").getAsString();
    String descrizione = jsonObject.get("updateOperazioneDesc").getAsString();
    String id = jsonObject.get("updateOperazioneId").getAsString();

    OperazioneBean o = operazioneModel.doRetrieveByKey(Integer.valueOf(id));

    if (o != null) {
      Boolean checkTipoOp = tipoOp.matches("[a-z A-Z]+$");
      Boolean checkDesc = descrizione.matches("[a-z A-Z]+$");
      if (checkDesc && checkTipoOp) {
        o.setTipoOperazione(tipoOp);
        o.setDescrizione(descrizione);
        operazioneModel.doUpdate(o);
        return true;
      } else {
        return false;
      }
    } else {
      throw new ObjectNotFoundException(o);
    }
  }
}
