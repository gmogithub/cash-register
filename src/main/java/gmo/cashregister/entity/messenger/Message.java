package gmo.cashregister.entity.messenger;

import gmo.cashregister.entity.person.Person;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cash_register_message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "messenger_id")
    private Messenger messenger;

    @Column
    private LocalDateTime date;

    @Column
    private boolean look;

    @OneToOne
    @JoinColumn(name = "person_sender_id")
    private Person personSender;

    @OneToOne
    @JoinColumn(name = "person_recipient_id")
    private Person personRecipient;

    public long getId() {
        return id;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isLook() {
        return look;
    }

    public void setLook(boolean look) {
        this.look = look;
    }

    public Person getPersonSender() {
        return personSender;
    }

    public void setPersonSender(Person personSender) {
        this.personSender = personSender;
    }

    public Person getPersonRecipient() {
        return personRecipient;
    }

    public void setPersonRecipient(Person personRecipient) {
        this.personRecipient = personRecipient;
    }
}
