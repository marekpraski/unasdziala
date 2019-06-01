package maven.unasdziala.parser;


    import org.apache.poi.ss.util.CellReference;

    public enum ColumnHeaders {
        DATA("A"),
        ZADANIE("B"),
        CZAS("C");

        private String column;

        ColumnHeaders(String column) {
            this.column = column;
        }

        public Integer getColumnIndex() {

            return CellReference.convertColStringToIndex(column);
        }


    }
