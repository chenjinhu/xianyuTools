# 闲鱼助手

> 目前啥功能也没用, 各位看观加个star
> 
> 感谢FATJS项目提供的思路, 本项目基础架构全抄FatJS.
> API接口参考easyclick 尽可能和easyclick保持一致.



- 免费
- 学习
- 长期维护更新
- 交流/提建议/定制化需求 加微信:cjh-18888


## 文档

### 全局快捷事件
####  点击
##### clickPoint 点击节点
- 点击坐标
- @param x x坐标
- @param y y坐标
- @return {boolean|布尔型}
```javascript
function main() {
    var result = clickPoint(100, 100);
    if (result) {
        toast("点击成功");
    } else {
        toast("点击失败");
    }
}

main();
```

##### click 选择器点击
- 点击选择器
- @param selectors 选择器对象
- @return {boolean|布尔型}
```javascript
function main() {
    var selector = text("我是文本").findOne();
    var result = selector.click();
    if (result) {
        toast("点击成功");
    } else {
        toast("点击失败");
    }
}

main();
```
####  滑动

### 选择器

---
参考项目
- https://github.com/zhyaoqi/platformautoplug
- https://github.com/1754048656/FATJS
- https://ieasyclick.com/