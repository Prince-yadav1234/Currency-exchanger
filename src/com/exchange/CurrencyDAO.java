package com.exchange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CurrencyDAO {

    public double getExchangeRate(String from, String to) {
        double rate = 0;
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT rate FROM exchange_rate WHERE from_currency=? AND to_currency=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, from.toUpperCase());
            ps.setString(2, to.toUpperCase());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rate = rs.getDouble("rate");
            } else {
                System.out.println("⚠️ Exchange rate not found for " + from + " → " + to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }

    public double convertCurrency(String from, String to, double amount) {
        double rate = getExchangeRate(from, to);
        if (rate == 0) return 0;
        return amount * rate;
    }
}