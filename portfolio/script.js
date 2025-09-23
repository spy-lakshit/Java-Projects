// Smooth scroll for nav links
document.querySelectorAll('.navbar a').forEach(link => {
  link.addEventListener('click', e => {
    const target = document.querySelector(link.getAttribute('href'));
    if (target) {
      e.preventDefault();
      target.scrollIntoView({ behavior: 'smooth', block: 'start' });
      target.setAttribute('tabindex', '-1');
      target.focus({ preventScroll: true });
    }
  });
});

// Keyboard accessibility: allow card focus
document.querySelectorAll('.project-card').forEach(card => {
  card.addEventListener('keydown', e => {
    if (e.key === 'Enter' || e.key === ' ') {
      // Find the link inside
      const link = card.querySelector('a');
      if (link) link.click();
    }
  });
});

// Contact form dummy submission with ARIA feedback
const form = document.getElementById('contactForm');
const successMessage = document.getElementById('successMessage');
form.addEventListener('submit', e => {
  e.preventDefault();
  successMessage.textCont// Smooth scroll
document.querySelectorAll('.navbar a').forEach(link => {
  link.addEventListener('click', e => {
    e.preventDefault();
    document.querySelector(link.getAttribute('href')).scrollIntoView({
      behavior: 'smooth'
    });
  });
});

// Contact form demo
const form = document.getElementById('contactForm');
const successMessage = document.getElementById('successMessage');

form.addEventListener('submit', e => {
  e.preventDefault();
  successMessage.textContent = "✅ Message sent successfully! (Demo)";
  form.reset();
  successMessage.style.color = "green";
});
ent = "✅ Your message has been sent! (Demo)";
  form.reset();
  setTimeout(() => { successMessage.textContent = ""; }, 5200);
});
