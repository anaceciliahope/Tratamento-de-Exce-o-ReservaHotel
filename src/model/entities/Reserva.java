package model.entities;

import exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroDoQuarto;
     private Date checkIn;
     private Date checkOut;
     private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     public Long duracao() {
         Long diferanca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferanca,TimeUnit.MILLISECONDS);
     }
     public void updateDates(Date checkIn, Date checkOut) throws DomainException {
         Date now = new Date();
         if (checkIn.before(now) || checkOut.before(now)) {
             throw new DomainException("As datas de reserva para atualização devem ser futuras");
         } if (! checkOut.after(checkIn)) {
             throw new DomainException("A data do check-out deve ser depois da data do check-in");
         }
         this.checkIn = checkIn;
         this.checkOut = checkOut;
     }
     public Reserva() {
     }
    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) throws DomainException {
        if (! checkOut.after(checkIn)) {
            throw new DomainException("A data do check-out deve ser depois da data do check-in");
        }
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return "Quarto: "
                + numeroDoQuarto
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duracao()
                + " noites";
    }
}
