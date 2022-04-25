package data;

import java.io.Serializable;

/**
 * Enum for ticket type
 */
public enum TicketType implements Serializable {
    VIP,
    USUAL,
    BUDGETARY,
    CHEAP
}