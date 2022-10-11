package com.example.bai_2_ung_dung_co_menu_hien_thi;

public class apps {
    private String name;
    private String packet;

    public apps(String name, String packet) {
        this.name = name;
        this.packet = packet;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }
}
