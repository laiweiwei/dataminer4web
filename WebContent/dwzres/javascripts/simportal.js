// JavaScript Document
/**
 * 选中某行
 * 
 * @param id
 *            某行id
 */
function selectBox(id){
	var checkbox = document.getElementById(id);
	if (checkbox != null){
		checkbox.checked = 1-checkbox.checked;
	}
}