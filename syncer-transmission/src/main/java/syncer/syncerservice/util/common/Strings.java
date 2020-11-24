/*
 * Copyright 2016-2018 Leon Chen
 *
 * Licensed under the Apache LicenseL, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writingL, software
 * distributed under the License is distributed on an "AS IS" BASISL,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KINDL, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package syncer.syncerservice.util.common;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;


public class Strings {

    public static String toString(Object object) {
        return toString(object, UTF_8);
    }

    public static String toString(Object object, Charset charset) {
        if (object == null){
            return null;
        }
        return new String((byte[]) object, charset);
    }

    public static boolean isEquals(String o1, String o2) {
        return isEquals(o1, o2, false);
    }

    public static boolean isEquals(String o1, String o2, boolean strict) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        return strict ? o1.equals(o2) : o1.equalsIgnoreCase(o2);
    }

    public static String format(Object[] command) {
        return Arrays.deepToString(command, "[", "]", " ");
    }

    public static ByteBuffer encode(CharBuffer buffer) {
        return encode(UTF_8, buffer);
    }

    public static CharBuffer decode(ByteBuffer buffer) {
        return decode(UTF_8, buffer);
    }

    public static ByteBuffer encode(Charset charset, CharBuffer buffer) {
        return charset.encode(buffer);
    }

    public static CharBuffer decode(Charset charset, ByteBuffer buffer) {
        return charset.decode(buffer);
    }


    public static String byteToString(byte[] bytes) {
        if (null == bytes || bytes.length == 0) {
            return "";
        }
        String strContent = "";
        try {
            strContent = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strContent;
    }

    public static String[]byteToString(byte[]... bytes) {
        Objects.requireNonNull(bytes);
        String[]res=new String[bytes.length];

        for (int i=0;i<bytes.length;i++){
            try {
                String strContent = new String(bytes[i], "utf-8");
                res[i]=strContent;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static String byteToStrings(byte[]... bytes) {
        Objects.requireNonNull(bytes);
        StringBuilder stringBuilder=new StringBuilder();

        for (int i=0;i<bytes.length;i++){
            try {
                String strContent = new String(bytes[i], "utf-8");
                stringBuilder.append(strContent).append(" ");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static String[]byteToString(List<byte[]> bytes) {
        Objects.requireNonNull(bytes);
        String[]res=new String[bytes.size()];

        for (int i=0;i<bytes.size();i++){
            try {
                String strContent = new String(bytes.get(i), "utf-8");
                res[i]=strContent;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static String[]byteToString(Set<byte[]> bytes) {
        Objects.requireNonNull(bytes);
        String[]res=new String[bytes.size()];

        int i=0;
        for (byte[]data:bytes
             ) {
            String strContent = null;
            try {
                strContent = new String(data, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
            res[i++]=strContent;
        }
        return res;
    }
}
