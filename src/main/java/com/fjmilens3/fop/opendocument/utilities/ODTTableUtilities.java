package com.fjmilens3.fop.opendocument.utilities;

import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for working with tables as part of the conversion process.
 *
 * @author Frederick John Milens III
 */
public final class ODTTableUtilities {

    /**
     * Private constructor for utility class.
     */
    private ODTTableUtilities() {
    }

    /**
     * Returns the top {@link Row} from a {@link Table}.
     *
     * @param table The table.
     * @return The top row.
     */
    public static Row getTopRow(Table table) {
        return table.getRowByIndex(0);
    }

    /**
     * Returns the bottom {@link Row} from a {@link Table}.
     *
     * @param table The table.
     * @return The bottom row.
     */
    public static Row getBottomRow(Table table) {
        return table.getRowByIndex(table.getRowCount() - 1);
    }

    /**
     * Returns the left {@link Column} from a {@link Table}.
     *
     * @param table The table.
     * @return The left column.
     */
    public static Column getLeftColumn(Table table) {
        return table.getColumnByIndex(0);
    }

    /**
     * Returns the right {@link Column} from a {@link Table}.
     *
     * @param table The table.
     * @return The right column.
     */
    public static Column getRightColumn(Table table) {
        return table.getColumnByIndex(table.getColumnCount() - 1);
    }

    /**
     * Returns a list of {@link Cell} instances contained by the specified row.
     *
     * @param row The {@link Row}.
     * @return The list of {@link Cell} objects.
     */
    public static List<Cell> getCellsFromRow(Row row) {
        List<Cell> cells = new ArrayList<Cell>();
        for (int index = 0; index < row.getCellCount(); index++) {
            cells.add(row.getCellByIndex(index));
        }
        return cells;
    }

    /**
     * Returns a list of {@link Cell} instances contained by the specified column.
     *
     * @param column The {@link Column}.
     * @return The list of {@link Cell} objects.
     */
    public static List<Cell> getCellsFromColumn(Column column) {
        List<Cell> cells = new ArrayList<Cell>();
        for (int index = 0; index < column.getCellCount(); index++) {
            cells.add(column.getCellByIndex(index));
        }
        return cells;
    }
}
