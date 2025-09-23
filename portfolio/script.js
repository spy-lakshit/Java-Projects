// Smooth scroll
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
