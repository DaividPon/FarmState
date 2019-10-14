package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Farmテーブルへのアクセスを行う
 * @author daividkdm
 *
 */
public class FarmDBOperator {
    // id
    private ArrayList<String> id = null;
    // 農場名
    private ArrayList<String> name = null;
    // グループ名
    private ArrayList<String> groupname = null;
    // 棟形態
    private ArrayList<String> type = null;
    // 更新日付
    private ArrayList<String> updatedate = null;
    // 更新時刻
    private ArrayList<String> updatetime = null;
    // 苗植え日
    private ArrayList<String> plantdate = null;
    // 収穫日
    private ArrayList<String> reapdate = null;
    // 収穫回数
    private ArrayList<Integer> reapcount = null;
    // 作物量
    private ArrayList<Integer> volume = null;

    /**
     * IDをキーにSELECTを実行する
     * @param id
     */
    public void selectId(String id) {
        init();
        String sql = "select * from farm where id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rset = ps.executeQuery();
            // SELECT結果抽出
            while (rset.next()) {
                this.id.add(rset.getString("id"));
                this.name.add(rset.getString("name"));
                this.groupname.add(rset.getString("groupname"));
                this.type.add(rset.getString("type"));
                this.updatedate.add(rset.getString("updatedate"));
                this.updatetime.add(rset.getString("updatetime"));
                this.plantdate.add(rset.getString("plantdate"));
                this.reapdate.add(rset.getString("reapdate"));
                this.reapcount.add(rset.getInt("reapcount"));
                this.volume.add(rset.getInt("volume"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null)
                    rset.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void init() {
        id = new ArrayList<String>();
        name = new ArrayList<String>();
        groupname = new ArrayList<String>();
        type = new ArrayList<String>();
        updatedate = new ArrayList<String>();
        updatetime = new ArrayList<String>();
        plantdate = new ArrayList<String>();
        reapdate = new ArrayList<String>();
        reapcount = new ArrayList<Integer>();
        volume = new ArrayList<Integer>();
    }

    /**
     * @return id
     */
    public ArrayList<String> getId() {
        return id;
    }

    /**
     * @param id セットする id
     */
    public void setId(ArrayList<String> id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public ArrayList<String> getName() {
        return name;
    }

    /**
     * @param name セットする name
     */
    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    /**
     * @return groupname
     */
    public ArrayList<String> getGroupname() {
        return groupname;
    }

    /**
     * @param groupname セットする groupname
     */
    public void setGroupname(ArrayList<String> groupname) {
        this.groupname = groupname;
    }

    /**
     * @return type
     */
    public ArrayList<String> getType() {
        return type;
    }

    /**
     * @param type セットする type
     */
    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    /**
     * @return updatedate
     */
    public ArrayList<String> getUpdatedate() {
        return updatedate;
    }

    /**
     * @param updatedate セットする updatedate
     */
    public void setUpdatedate(ArrayList<String> updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * @return updatetime
     */
    public ArrayList<String> getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime セットする updatetime
     */
    public void setUpdatetime(ArrayList<String> updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return plantdate
     */
    public ArrayList<String> getPlantdate() {
        return plantdate;
    }

    /**
     * @param plantdate セットする plantdate
     */
    public void setPlantdate(ArrayList<String> plantdate) {
        this.plantdate = plantdate;
    }

    /**
     * @return reapdate
     */
    public ArrayList<String> getReapdate() {
        return reapdate;
    }

    /**
     * @param reapdate セットする reapdate
     */
    public void setReapdate(ArrayList<String> reapdate) {
        this.reapdate = reapdate;
    }

    /**
     * @return reapcount
     */
    public ArrayList<Integer> getReapcount() {
        return reapcount;
    }

    /**
     * @param reapcount セットする reapcount
     */
    public void setReapcount(ArrayList<Integer> reapcount) {
        this.reapcount = reapcount;
    }

    /**
     * @return volume
     */
    public ArrayList<Integer> getVolume() {
        return volume;
    }

    /**
     * @param volume セットする volume
     */
    public void setVolume(ArrayList<Integer> volume) {
        this.volume = volume;
    }

}
