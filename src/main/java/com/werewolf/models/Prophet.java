package com.werewolf.models;

import java.util.Map;


public class Prophet extends Role {

    private int type = GOD;
    private ExecuteResultModel result = null;
    private static String name = "PROPHET";

    @Override
    public Object execute(Map<String, Object> param) {

        boolean isGoodMam = true;
        Player player = (Player)param.get("Player");

        if(1 == player.getRole().getType()){
            isGoodMam = false;
        }

        result.setTargetSitId(player.getSitId());
        result.setExecuteResult(isGoodMam);

        return result;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }


}
