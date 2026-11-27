const box = document.querySelector('.tab-box');
const buttons = box.querySelectorAll('.tab-btn');
const contents = box.querySelectorAll('.tab-content');

    buttons.forEach((btn) => {
    /*WHAT: when page is loaded add event litstener to all buttons
      WHY: to change state and content*/
    btn.addEventListener('click', () => {
        const targetId = btn.dataset.tab;

        /*  WHAT: click -> targetId is set to data-tab
            WHY: The naming matches the IDs of the tab contents, so now we can link the two.            */

        buttons.forEach((b) => {
            b.classList.remove('active');
            b.setAttribute('aria-selected', 'false');
            /* WHAT: click: for all buttons/tabs (b) remove class 'active' and set 'aria-selected' to false
               WHY: the tab previously active should not be, and this way we don't need to know which tab we're coming from.*/
        });
        contents.forEach((c) => c.classList.remove('active'));
        /* WHAT: for all contents remove class 'active'*/

        btn.classList.add('active');
        /* WHAT: for the clicked button/tab (btn) add class 'active'
           WHY: right now no buttons/tabs are active, the clicked button/tab should be, class active changes styling*/

        btn.setAttribute('aria-selected', 'true');
        /* WHAT: for the chosen button/tab change 'aria-selected' to true */

        box.querySelector(`#${targetId}`).classList.add('active');
        /* WHAT: for the chosen button/tab add class 'active' on tab content with id=targetId, we are lookingg in the 'box' variable defined in the beginning of the function.
           WHY: class active makes contents visible via CSS*/
    });
});
