//-------------------- pre set -------------------//
let task = new engines();
const getHashMapBuffer = () => {
    let buffer = task._getHashMapBuffer();
    if(buffer != null) {
        return buffer;
    }
    return null;
}

// -------------------- 日志输出类 -------------------//
const print = (msg) => task._print(msg + '');
const showLog = () => task._showLog();
const hideLog = () => task._hideLog();
const fullScreenLog = () => task._fullScreenLog();
const clearLog = () => task._clearLog();
// -------------------- 基础类 -------------------//
const home = () => task._home();
const back = () => task._back();

// -------------------- 时间类 -------------------//
const sleep = (ms) => task._sleep(ms);

// -------------------- 网络请求类 -------------------//

// -------------------- 工具类 -------------------//

//-------------------- pre end -------------------//