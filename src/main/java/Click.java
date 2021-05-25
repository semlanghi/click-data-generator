import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Click implements ClickRecord {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date eventTime;
    @JsonFormat
    private String username;
    @JsonFormat
    private String region;

    public Click() {
    }

    public Click(Date eventTime, String username, String region) {
        this.eventTime = eventTime;
        this.username = username;
        this.region = region;
    }

    @Override
    public Date getEventTime() {
        return eventTime;
    }
}
